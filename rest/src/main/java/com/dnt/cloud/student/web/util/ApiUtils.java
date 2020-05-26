/**
 * 
 */
package com.dnt.cloud.student.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.dnt.cloud.common.domain.LogPrefixFactory;

/**
 * HTTPS请求：Tiens api平台
 * @author julio
 * 2018年11月24日
 */
public class ApiUtils {
	
	private static Logger logger = LoggerFactory.getLogger(ApiUtils.class);
	
	public static final String ACCEPT_JSON = "application/json";
	
	/**
	 * 直接访问后端地址
	 * @param url 接口地址
	 * @param parameter 参数
	 * @param parameterFlg 参数方式[0：path方式，1：model方式]
	 * @param contentType：application/json
	 * @return
	 * @throws Exception
	 */
    public static String sendRequestByPath(String url)throws Exception{
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            logger.info("请求地址：" + realUrl.toString());

            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setDoInput(true);// 创建输入流，必须有
            conn.setDoOutput(true);// 创建输出流，必须有
            conn.setUseCaches(false);// 不缓存
            conn.setConnectTimeout(60000);// 连接超时
            conn.setReadTimeout(60000);// 响应超时
            conn.setRequestMethod("GET");

            conn.addRequestProperty("Charset", "UTF-8");
            conn.addRequestProperty("content-type",ACCEPT_JSON);
            conn.addRequestProperty("Connection", "Keep-Alive");
            conn.addRequestProperty("Accept", MediaType.APPLICATION_JSON.toString());
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return buffer.toString();
    }
    
	/**
	 * 直接访问后端地址
	 * @param url 接口地址
	 * @param parameter 参数
	 * @param parameterFlg 参数方式[0：path方式，1：model方式]
	 * @param contentType：application/json
	 * @return
	 * @throws Exception
	 */
    public static String sendRequestByPath(String url,String parameter)throws Exception{
        logger.info("=========发送微信消息模板=========sendRequestByPath" );
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            logger.info("=========请求地址========={}", realUrl.toString());
            logger.info("=========请求的参数========={}",parameter);

            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setDoInput(true);// 创建输入流，必须有
            conn.setDoOutput(true);// 创建输出流，必须有
            conn.setUseCaches(false);// 不缓存
            conn.setConnectTimeout(60000);// 连接超时
            conn.setReadTimeout(60000);// 响应超时
            conn.setRequestMethod("POST");

            conn.addRequestProperty("Charset", "UTF-8");
            conn.addRequestProperty("content-type",ACCEPT_JSON);
            conn.addRequestProperty("Connection", "Keep-Alive");
            conn.addRequestProperty("Accept", MediaType.APPLICATION_JSON.toString());
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            
            // 发送请求参数
            out.print(parameter);

            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
            logger.info("{}=====请求返回的状态码==={}",LogPrefixFactory.getLogPrefix(),conn.getResponseCode());
            logger.info("{}=====请求返回的结果值==={}",LogPrefixFactory.getLogPrefix(),conn.getResponseMessage());
            
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return buffer.toString();
    }

	
	public static void main(String[] args) throws Exception {
		//创建变量
		Map<String, Object> parm = new HashMap<String, Object>();
		Map<String, Map<String, Object>> data = new HashMap<String, Map<String,Object>>();
		Map<String, Object> first = new HashMap<String, Object>();
		Map<String, Object> keyword1 = new HashMap<String, Object>();
		Map<String, Object> keyword2 = new HashMap<String, Object>();
		Map<String, Object> keyword3 = new HashMap<String, Object>();
		Map<String, Object> remark = new HashMap<String, Object>();
		Map<String, Object> miniprogram = new HashMap<String, Object>();
		parm.put("touser", "oH5pz5wYwhzYKR6ogHESMwUsROa0");//openId
		parm.put("template_id", "P8hnhRW_JmTT3dwwclt__G7ICBOTevj6W7ezAqS0XrE");//消息模板的id
		miniprogram.put("appid", "wxc4dd45942198b902");
		miniprogram.put("pagepath", "pages/todo/todo");
		parm.put("miniprogram", miniprogram);
		first.put("value", "合同");//标题
		first.put("color", "#173177");//标题颜色
		keyword1.put("value", "111——等待超级管理员审核");
		keyword1.put("color", "#173177");
		keyword2.put("value", "超级管理员");
		keyword2.put("color", "#173177");
		keyword3.put("value", "超级管理员");
		keyword3.put("color", "#173177");
		remark.put("value", "请您及时处理事务。");
		remark.put("color", "#173177");
		data.put("first", first);
		data.put("keyword1", keyword1);
		data.put("keyword2", keyword2);
		data.put("keyword3", keyword3);
		data.put("remark", remark);
		parm.put("data", data);
		String result = sendRequestByPath("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=33_i3_gl0ksHPPdYAVW9KSvZKHRq_okOQjwWco4P8GHQODe5Z_QsJWwYuwNL4TtL8eCijJ_F6b-3UZnyuWP2ym3dfYdSeLA1yJLAelZ9sQhRXswkZ-nbRuVS7RILkk4XIPpMPcVfVkTJN_DjTKATZIfAJADJS", JSONObject.toJSONString(parm));
		System.out.println(result);
	}
}
