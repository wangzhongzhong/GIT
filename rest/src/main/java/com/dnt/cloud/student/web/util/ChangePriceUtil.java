package com.dnt.cloud.student.web.util;

import java.text.DecimalFormat;

import com.dnt.cloud.common.lang.StringUtil;

/**
 * 转换保留2位小数的价格
 * @author decade 
 *
 */
public class ChangePriceUtil {
	
	public static String changePrice(String price) {
		String newPrice = "￥0.00";
		if(StringUtil.isNotBlank(price)){
			Double d= Double.parseDouble(price);
			DecimalFormat df = new DecimalFormat("0.00");
			newPrice = "￥"+df.format(d);
		}
		return newPrice;
	}

}
