package com.dnt.cloud.student.query;

import java.util.Date;

import com.dnt.cloud.common.domain.query.PageQuery;

public class NrcTeachClassQuery extends PageQuery{
    private Long id;

    private Long nrcClassId;

    private Long nrcTeachtId;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNrcClassId() {
        return nrcClassId;
    }

    public void setNrcClassId(Long nrcClassId) {
        this.nrcClassId = nrcClassId;
    }

    public Long getNrcTeachtId() {
        return nrcTeachtId;
    }

    public void setNrcTeachtId(Long nrcTeachtId) {
        this.nrcTeachtId = nrcTeachtId;
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