package com.dnt.cloud.student.model;

import java.io.Serializable;
import java.util.Date;

public class NrcStudentParent implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nrcStudentId=").append(nrcStudentId);
        sb.append(", nrcParentId=").append(nrcParentId);
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
        NrcStudentParent other = (NrcStudentParent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNrcStudentId() == null ? other.getNrcStudentId() == null : this.getNrcStudentId().equals(other.getNrcStudentId()))
            && (this.getNrcParentId() == null ? other.getNrcParentId() == null : this.getNrcParentId().equals(other.getNrcParentId()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNrcStudentId() == null) ? 0 : getNrcStudentId().hashCode());
        result = prime * result + ((getNrcParentId() == null) ? 0 : getNrcParentId().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}