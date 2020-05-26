/**
 * 
 */
package com.dnt.cloud.student.enums;

import com.dnt.cloud.common.domain.enums.EnumBase;

/**
 * @author julio
 *
 */
public enum NrcTeachTypeEnum implements EnumBase {
	B("B","班主任"),
	D("D","代课老师");
	
	private final String code;
	
	private final String message;
	
	NrcTeachTypeEnum(String code,String message) {
		this.code = code;
		this.message=message;
	}
	
	public static NrcTeachTypeEnum getByCode(String code) {
        for (NrcTeachTypeEnum resultCode : NrcTeachTypeEnum.values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return null;
    }
	

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
