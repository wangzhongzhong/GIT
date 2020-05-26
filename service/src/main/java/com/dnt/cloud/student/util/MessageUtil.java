package com.dnt.cloud.student.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dnt.cloud.student.wx.domain.NewsDomain;
import com.dnt.cloud.student.wx.domain.NewsMessageDomain;
import com.dnt.cloud.student.wx.domain.TextMessageDomain;

/**
 * 处理微信公众号响应消息的工具类
 * @author julio
 *
 */
public class MessageUtil {
	public static final String MESSAGE_IMAGE="image";//图片
	public static final String MSGTYPE_EVENT = "event";//消息类型--事件
	public static final String MESSAGE_SUBSCIBE = "subscribe";//消息事件类型--订阅事件
	public static final String MESSAGE_UNSUBSCIBE = "unsubscribe";//消息事件类型--取消订阅事件
	public static final String MESSAGE_TEXT = "text";//消息类型--文本消息
	public static final String MESSAGE_SCAN = "SCAN";//消息类型--已关注事件
	public static final String MESSAGE_VIEW = "VIEW";//消息类型--点击菜单跳转链接时的事件推送
	public static final String MESSAGE_NEWS = "news";//图文消息
	public static final String MESSAGE_CLICK = "CLICK"; //点击菜单拉取消息时的事件推送
	
	/*
	 * 组装文本消息
	 */
	public static String textMsg(String toUserName,String fromUserName,String content){
		TextMessageDomain text = new TextMessageDomain();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return XmlUtil.textMsgToxml(text);
	}
	
	/**
	 * 图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @param picUrl:图片链接
	 * @param url:跳转的url
	 * @return
	 */
	public static String newsMsg(String toUserName,String fromUserName,String picUrl,String url){
        List<NewsDomain> newsList = new ArrayList<NewsDomain>();
        NewsMessageDomain newsMessage = new NewsMessageDomain();
        //组建一条图文↓ ↓ ↓
        NewsDomain newsItem = new NewsDomain();
        newsItem.setTitle("欢迎关注我的公众号");
        newsItem.setDescription("点击查看商品详情");
        newsItem.setPicurl(picUrl);
        newsItem.setUrl(url);
        newsList.add(newsItem);
        //组装图文消息相关信息
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());
        return XmlUtil.imageMsgToxml(newsMessage);
	}
	
	/*
	 * 响应订阅事件--回复文本消息
	 */
	public static String subscribeForText(
			String toUserName,String fromUserName,
			String content){
		return textMsg(toUserName, fromUserName, content);
	}
	
	/*
	 * 响应取消订阅事件
	 */
	public static String unsubscribe(String toUserName,String fromUserName){
		//TODO 可以进行取关后的其他后续业务处理
		System.out.println("用户："+ fromUserName +"取消关注~");
		return "";
	}
}
