package com.dnt.cloud.student.domain;

import java.util.Date;

import com.dnt.cloud.common.domain.BaseDomain;

public class NrcStudentDomain extends BaseDomain{
    private Long id;

    private String studentNo;

    private String name;

    private Long nrcClassId;

    private Date gmtCreate;

    private Date gmtModify;
    
    /**
     * 班级名称
     */
    private String nrcClassName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getNrcClassId() {
        return nrcClassId;
    }

    public void setNrcClassId(Long nrcClassId) {
        this.nrcClassId = nrcClassId;
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

	public String getNrcClassName() {
		return nrcClassName;
	}

	public void setNrcClassName(String nrcClassName) {
		this.nrcClassName = nrcClassName;
	}

}