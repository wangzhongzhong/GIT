/**
 * 
 */
package com.dnt.cloud.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dnt.cloud.student.wx.domain.NewsDomain;
import com.dnt.cloud.student.wx.domain.NewsMessageDomain;
import com.dnt.cloud.student.wx.domain.TextMessageDomain;
import com.thoughtworks.xstream.XStream;

/**
 * @author julio
 * 处理微信的xml工具类
 */
public class XmlUtil {
	
	/*
	 * xml转map
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		HashMap<String, String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
 
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
 
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = (List<Element>)root.elements();
 
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	/*
	 * 文本消息对象转xml
	 */
	public static String textMsgToxml(TextMessageDomain textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/*
	 * 图文消息转XML结构方法
	 */
	public static String imageMsgToxml(NewsMessageDomain imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		xstream.alias("item", new NewsDomain().getClass());
		return xstream.toXML(imageMessage);
	}

}
