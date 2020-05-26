package com.dnt.cloud.student.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * layui 框架专用返回数据格式封装,可重新在config中配置对应的K,V名称,此处使用layui默认K,V。
 * @author Administrator
 *
 */
public class EscapeDomainUtils extends HashMap<String,Object>{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static Object escapeDomaindata(Object domain){
		
		Field[] field = domain.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
				String name = field[i].getName();
				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				String type = field[i].getGenericType().toString();
				if (type.equals("class java.lang.String")) {
					Method m = null;
					try {
						m = domain.getClass().getMethod("get" + name);
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
					String value = null;
					try {
						value = (String) m.invoke(domain);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					if(StringUtils.isNotBlank(value)){
						try {
							m = domain.getClass().getDeclaredMethod("set" + name,String.class);
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						}
						String repval =StringEscapeUtils.unescapeHtml(value);
//						String repval = value.replaceAll("&", "&amp;").replaceAll("'", "&apos;")
//								.replaceAll("\"", "&quot;").replaceAll(">", "&gt;").replaceAll("<", "&lt;");
						try {
							m.invoke(domain,repval);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
		}
	   return domain;
    }

	/**
	 * 单个字符转义
	 * @return
	 */
	public static  String escape(String value){
		return StringEscapeUtils.unescapeHtml(value);
	}
	
}
