package com.dnt.cloud.student.web.domain;

/**
 * layui数据模板
 * @author decade
 *
 */
public class NrcDataDomain {
    /**响应编码*/
    private int code;
    /**响应消息*/
    private String msg;
    /**数据总量*/
    private Long count;
    /**数据*/
    private Object data;

    public NrcDataDomain() {
    }
    
    public NrcDataDomain(int code) {
    	this.code = code;
    }

    public NrcDataDomain(int code, String msg, Long count, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "R [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
