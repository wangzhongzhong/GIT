package com.dnt.cloud.student.model;

import java.io.Serializable;
import java.util.Date;

public class NrcOfficialAccount implements Serializable {
    private Long id;

    private String attension;

    private String bottomMenu;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttension() {
        return attension;
    }

    public void setAttension(String attension) {
        this.attension = attension == null ? null : attension.trim();
    }

    public String getBottomMenu() {
        return bottomMenu;
    }

    public void setBottomMenu(String bottomMenu) {
        this.bottomMenu = bottomMenu == null ? null : bottomMenu.trim();
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
        sb.append(", attension=").append(attension);
        sb.append(", bottomMenu=").append(bottomMenu);
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
        NrcOfficialAccount other = (NrcOfficialAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAttension() == null ? other.getAttension() == null : this.getAttension().equals(other.getAttension()))
            && (this.getBottomMenu() == null ? other.getBottomMenu() == null : this.getBottomMenu().equals(other.getBottomMenu()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAttension() == null) ? 0 : getAttension().hashCode());
        result = prime * result + ((getBottomMenu() == null) ? 0 : getBottomMenu().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}