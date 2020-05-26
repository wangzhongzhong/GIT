package com.dnt.cloud.student.util;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 *
 */
public class Json2Map {
    /**
     * 将json字符串转为Map结构
     * 如果json复杂，结果可能是map嵌套map
     * @param jsonStr 入参，json格式字符串
     * @return 返回一个map
     */
	public static Map<String, Object> json2Map(String jsonStr) {
    	JSONObject jsonObject;
        jsonObject = JSON.parseObject(jsonStr);
		Set<String> keyIter = jsonObject.keySet();
		Object value;
		Map<String, Object> valueMap = new HashMap<String, Object>();
		for(String str : keyIter){
		    value = jsonObject.get(str);
		    valueMap.put(str, value);
		}
		return valueMap;
    }
}
