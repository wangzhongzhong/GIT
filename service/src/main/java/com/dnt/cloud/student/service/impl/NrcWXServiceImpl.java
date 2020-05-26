/**
 * 
 */
package com.dnt.cloud.student.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.service.NrcWXService;
import com.dnt.cloud.student.util.ApiUtils;
import com.dnt.cloud.student.util.Json2Map;
import com.github.binarywang.java.emoji.EmojiConverter;

/**
 * @author julio
 *
 */
@Service("nrcWXService")
public class NrcWXServiceImpl implements NrcWXService {
	
	private Logger logger = LoggerFactory.getLogger(NrcWXServiceImpl.class);
	
	@Value("${nrc.wx.appId}")
	private String appId;
	
	@Value("${nrc.wx.appSecret}")
	private String appSecret;
	
	/**
	 * 基础的access_token的url
	 */
	@Value("${nrc.wx.baseTokenUrl:https://api.weixin.qq.com/cgi-bin/token?}")
	private String baseTokenUrl;

	/**
	 * 获取用户基本信息
	 */
	@Value("${nrc.wx.userInfoUrl:https://api.weixin.qq.com/cgi-bin/user/info?}")
	private String userInfoUrl;
	
	/**
	 * 关注推送消息后,商品详情路径+spuId
	 */
	@Value("${nrc.wx.textSpuDetailUrl:http://www.scanall-nrc.cn/cloud-manager/h5/spuDetail?spuId=}")
	private String textSpuDetailUrl;
	
	/**
	 * 创建菜单链接url
	 */
	@Value("${nrc.wx.createMenuUrl:https://api.weixin.qq.com/cgi-bin/menu/create?}")
	private String createMenuUrl;
	
	/**
	 * 关注后推送给微信的信息
	 */
	@Value("${nrc.wx.sendTextMessage:感谢关注 CreativePlus；\n{0}（道具名称）\n<a href={1}>点击查看详情</a>}")
	private String sendTextMessage;
	
	@Override
	public Map<String, Object> getBaseAccessTokenResult(String appId,String appSecret) {
		String access_token_result;
		try {
			access_token_result = ApiUtils.sendRequestByPath(baseTokenUrl + "&grant_type=client_credential" + "&appid=" + appId + "&secret=" + appSecret);
			logger.info("=======获取基础access_token======：{}",access_token_result);
			Map<String, Object> access_tokenMap = Json2Map.json2Map(access_token_result);
			return access_tokenMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String attentionMessage(String fromUserName, String eventKey,
			String eventType) {
		//把eventKey处理一下,取出我们的spuid
		eventKey = eventKey.substring(eventKey.indexOf("_")+1, eventKey.length());
		//处理微信昵称出现表情的问题
		EmojiConverter emojiConverter = EmojiConverter.getInstance();
		//1. 当前openId的基本信息
		Map<String, Object> userInfoMap = this.dealWithUserInfo(fromUserName,eventKey);
		//4. 处理下文本消息
		String result = "";
		return result;
	}
	

	/**
	 * 获取当前用户的基本信息
	 * @param fromUserName
	 * @param eventKey
	 * @return
	 */
	private Map<String, Object> dealWithUserInfo(String fromUserName,
			String eventKey) {
		//把eventKey处理一下,取出我们的spuid
		eventKey = eventKey.substring(eventKey.indexOf("_")+1, eventKey.length());
		//1. 通过spuId绑定的商户,查询出微信公众号的appId和appSercet
		Map<String, String> appIdAndAppSercet = null;
		if (appIdAndAppSercet == null) {
			return null;
		}
		//2. 获取基本token
		Map<String, Object> baseAccessTokenMap = this.getBaseAccessTokenResult("","");
		if (baseAccessTokenMap == null) {
			return null;
		}
		String access_token = (String) baseAccessTokenMap.get("access_token");
		//3. 获取openId所对应的基本信息
		try {
			String userInfoResult = ApiUtils.sendRequestByPath(userInfoUrl + "access_token=" + access_token + "&openid=" + fromUserName + "&lang=zh_CN");
			logger.info("========返回的用户信息==========:{}",userInfoResult);
			Map<String, Object> userInfoMap = Json2Map.json2Map(userInfoResult);
			return userInfoMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void getCreateMenuResult() {
		if (StringUtil.isNotBlank(appId) && StringUtil.isNotBlank(appSecret)) {
			Map<String, Object> accessTokenMap = this.getBaseAccessTokenResult(appId, appSecret);
			String access_token = (String) accessTokenMap.get("access_token");
			try {
				logger.info("=======创建菜单的请求参数=======:{}","");
				ApiUtils.sendRequestByPath(createMenuUrl + "access_token=" + access_token,"");
			} catch (Exception e) {
				logger.info("=======创建菜单列表异常======:{}",e);
			}
		}
	}
	
}
