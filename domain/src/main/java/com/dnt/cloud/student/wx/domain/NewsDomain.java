/**
 * 
 */
package com.dnt.cloud.student.wx.domain;

/**
 * @author julio
 * 图文消息实体类
 */
public class NewsDomain extends BaseMessageDomain {
	
	private String Title;//图文标题
	
    private String Description;//图文描述
    
    private String Picurl;//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    
    private String Url;//点击图文消息跳转链接

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicurl() {
		return Picurl;
	}

	public void setPicurl(String picurl) {
		Picurl = picurl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
