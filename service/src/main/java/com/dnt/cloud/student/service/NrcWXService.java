/**
 * 
 */
package com.dnt.cloud.student.service;

import java.util.Map;

/**
 * 处理微信服务的接口
 * @author julio
 *
 */
public interface NrcWXService {
	
	/**
	 * 微信--获取基本的access_token
	 * @param appId:微信公众号开发者appId
	 * @param secret:微信公众号开发者secret
	 * @return
	 */
	public Map<String, Object> getBaseAccessTokenResult(String appId,String secret);

	/**
	 * 微信--处理微信关注事件
	 * @param fromUserName:openId
	 * @param eventKey:生成有参二维码的请求参数--spuId
	 * @param eventType:事件类型
	 * @return
	 */
	public String attentionMessage(String fromUserName,String eventKey,String eventType);

	/**
	 * 创建指定商户下面的菜单
	 * @param merchantId
	 */
	public void getCreateMenuResult();

}
