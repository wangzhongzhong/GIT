package com.dnt.cloud.student.domain;

import java.util.Date;

import com.dnt.cloud.common.domain.BaseDomain;

public class NrcStudentParentDomain extends BaseDomain{
    private Long id;

    private Long nrcStudentId;

    private Long nrcParentId;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNrcStudentId() {
        return nrcStudentId;
    }

    public void setNrcStudentId(Long nrcStudentId) {
        this.nrcStudentId = nrcStudentId;
    }

    public Long getNrcParentId() {
        return nrcParentId;
    }

    public void setNrcParentId(Long nrcParentId) {
        this.nrcParentId = nrcParentId;
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