package com.dnt.cloud.student.web.util;

import org.springframework.util.Base64Utils;

import com.dnt.cloud.common.util.MD5Builder;

public class EncryptUtil {
	
	public static String enCrypt(String str){
    	return Base64Utils.encodeToString(MD5Builder.getMD5(str).getBytes());
    }

}
