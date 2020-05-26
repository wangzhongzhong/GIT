package com.dnt.cloud.student.query;

import java.util.Date;

import com.dnt.cloud.common.domain.query.PageQuery;

public class NrcRoleResouceQuery extends PageQuery {
    private Long id;

    private Long resourceId;

    private Long roleId;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

}