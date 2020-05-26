package com.dnt.cloud.student.domain;

import java.util.Date;

import com.dnt.cloud.common.domain.BaseDomain;

public class NrcClassMateDomain extends BaseDomain {
    private Long id;

    /**
     * 级数：
            2015级
            2016级
     */
    private String period;

    /**
     * 例如：
            三年级二班；
            九年级一班；
            高一五班；
            高三八班；
     */
    private String name;

    private String teachName;

    private Long teachId;

    private Long num;

    private String operator;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName == null ? null : teachName.trim();
    }

    public Long getTeachId() {
        return teachId;
    }

    public void setTeachId(Long teachId) {
        this.teachId = teachId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}