package com.dnt.cloud.student.model;

import java.io.Serializable;
import java.util.Date;

public class NrcUserRole implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nrcUserId=").append(nrcUserId);
        sb.append(", nrcRoleId=").append(nrcRoleId);
        sb.append(", operator=").append(operator);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NrcUserRole other = (NrcUserRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNrcUserId() == null ? other.getNrcUserId() == null : this.getNrcUserId().equals(other.getNrcUserId()))
            && (this.getNrcRoleId() == null ? other.getNrcRoleId() == null : this.getNrcRoleId().equals(other.getNrcRoleId()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNrcUserId() == null) ? 0 : getNrcUserId().hashCode());
        result = prime * result + ((getNrcRoleId() == null) ? 0 : getNrcRoleId().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}