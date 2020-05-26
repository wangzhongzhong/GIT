package com.dnt.cloud.student.domain;

import java.util.Date;

import com.dnt.cloud.common.domain.BaseDomain;

public class NrcUserRoleDomain extends BaseDomain{
    private Long id;

    private Long nrcUserId;

    private Long nrcRoleId;

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

    public Long getNrcUserId() {
        return nrcUserId;
    }

    public void setNrcUserId(Long nrcUserId) {
        this.nrcUserId = nrcUserId;
    }

    public Long getNrcRoleId() {
        return nrcRoleId;
    }

    public void setNrcRoleId(Long nrcRoleId) {
        this.nrcRoleId = nrcRoleId;
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