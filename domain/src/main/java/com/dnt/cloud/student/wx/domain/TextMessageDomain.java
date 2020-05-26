/**
 * 
 */
package com.dnt.cloud.student.wx.domain;

/**
 * @author julio
 * 文本消息类
 */
public class TextMessageDomain extends BaseMessageDomain {
	
	private String Content;
	private String MsgId;	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

}
