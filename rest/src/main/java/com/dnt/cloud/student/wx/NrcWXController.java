/**
 * 
 */
package com.dnt.cloud.student.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.dnt.cloud.CommonConstants;
import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.service.NrcWXService;
import com.dnt.cloud.student.util.CheckSignatureUtil;
import com.dnt.cloud.student.util.MessageUtil;
import com.dnt.cloud.student.util.XmlUtil;
import com.dnt.cloud.web.common.BaseController;

/**
 * 处理微信公众号的业务
 * @author julio
 *
 */
@Controller
public class NrcWXController extends BaseController {
	
	@Autowired
	private NrcWXService nrcWxService;
	
	/**
	 * 获取关注事件
	 * @param mess
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/nrcWxController/checkToken",method = RequestMethod.POST)
	public void getFocusOnTheEvent(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String message = "success";
		String backContent = ""; //处理图文消息返回结果
		try {
			//把微信返回的xml信息转义成map
			Map<String, String> map = XmlUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");//消息来源用户标识
			String toUserName = map.get("ToUserName");//消息目的用户标识
			String msgType = map.get("MsgType");//消息类型
			String content = map.get("Content");//消息内容
			String eventKey = map.get("EventKey");//事件key值，是一个32位无符号整数，即创建二维码时的二维码scene_id
			logger.info("======微信的xml=======:{}",JSONObject.toJSONString(map));
			logger.info("FromUserName:{},ToUserName:{},MsgType:{},Content:{},EventKey:{}",fromUserName,toUserName,msgType,content,eventKey);
			String eventType = map.get("Event");
			if(CommonConstants.MSGTYPE_EVENT.equals(msgType)){
				//如果为事件类型
				if(CommonConstants.MESSAGE_SUBSCIBE.equals(eventType)){
					//处理订阅事件
					backContent = nrcWxService.attentionMessage(fromUserName,eventKey,eventType);
					message = MessageUtil.subscribeForText(toUserName, fromUserName,backContent);
				}else if(CommonConstants.MESSAGE_SCAN.equals(eventType)){
					//已关注事件
					backContent = nrcWxService.attentionMessage(fromUserName,eventKey,eventType);
					message = MessageUtil.subscribeForText(toUserName, fromUserName,backContent);
					logger.info("======关注事件触发返回结果======:{}",message);
				}else if(CommonConstants.MESSAGE_CLICK.equals(eventType)){
					//点击菜单拉取消息时的事件推送
					if (StringUtil.equals("partner", eventKey)) {
						message = MessageUtil.subscribeForText(toUserName, fromUserName, "请留下您的联系方式和合作内容，我们将尽快联系您！");
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.println(message);
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 微信公众号平台验签,开启服务应用,是否通过
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value = "/nrcWxController/checkToken",method = RequestMethod.GET)
	public void checkToken(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        logger.info("signature:{},timestamp:{},nonce:{},echostr:{}",
        		signature,timestamp,nonce,echostr);
        PrintWriter out = response.getWriter();
        //调用比对signature的方法，实现对token和传入的参数进行hash算法后的结果比对
        if(CheckSignatureUtil.checkSignature(signature, timestamp, nonce)){
            out.print(echostr);
        } 
	}
	
	/**
	 * 创建微信公众号下面的菜单
	 */
	@RequestMapping(value = "/wxContro/createMenu")
	public void createMenu(){
		nrcWxService.getCreateMenuResult();
	}
	
}
