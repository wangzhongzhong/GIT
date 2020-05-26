package com.dnt.cloud.student.model;

import java.io.Serializable;
import java.util.Date;

public class NrcTeachClass implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nrcClassId=").append(nrcClassId);
        sb.append(", nrcTeachtId=").append(nrcTeachtId);
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
        NrcTeachClass other = (NrcTeachClass) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNrcClassId() == null ? other.getNrcClassId() == null : this.getNrcClassId().equals(other.getNrcClassId()))
            && (this.getNrcTeachtId() == null ? other.getNrcTeachtId() == null : this.getNrcTeachtId().equals(other.getNrcTeachtId()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNrcClassId() == null) ? 0 : getNrcClassId().hashCode());
        result = prime * result + ((getNrcTeachtId() == null) ? 0 : getNrcTeachtId().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}