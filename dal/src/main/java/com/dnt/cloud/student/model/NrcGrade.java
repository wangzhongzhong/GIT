package com.dnt.cloud.student.model;

import java.io.Serializable;
import java.util.Date;

public class NrcGrade implements Serializable {
    private Long id;

    /**
     * 考试id
     */
    private Long nrcExamId;

    /**
     * 2020年5月份月考
     */
    private Long nrcClassId;

    /**
     * 学年：2019
            2020
     */
    private String tear;

    /**
     * 2020年5月份月考
     */
    private String title;

    private String math;

    private String chiness;

    private String english;

    private String physics;

    private String chemistry;

    private String content1;

    private String content2;

    private String content3;

    private String content5;

    private String content4;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNrcExamId() {
        return nrcExamId;
    }

    public void setNrcExamId(Long nrcExamId) {
        this.nrcExamId = nrcExamId;
    }

    public Long getNrcClassId() {
        return nrcClassId;
    }

    public void setNrcClassId(Long nrcClassId) {
        this.nrcClassId = nrcClassId;
    }

    public String getTear() {
        return tear;
    }

    public void setTear(String tear) {
        this.tear = tear == null ? null : tear.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math == null ? null : math.trim();
    }

    public String getChiness() {
        return chiness;
    }

    public void setChiness(String chiness) {
        this.chiness = chiness == null ? null : chiness.trim();
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english == null ? null : english.trim();
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics == null ? null : physics.trim();
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry == null ? null : chemistry.trim();
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1 == null ? null : content1.trim();
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2 == null ? null : content2.trim();
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3 == null ? null : content3.trim();
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5 == null ? null : content5.trim();
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4 == null ? null : content4.trim();
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
        sb.append(", nrcExamId=").append(nrcExamId);
        sb.append(", nrcClassId=").append(nrcClassId);
        sb.append(", tear=").append(tear);
        sb.append(", title=").append(title);
        sb.append(", math=").append(math);
        sb.append(", chiness=").append(chiness);
        sb.append(", english=").append(english);
        sb.append(", physics=").append(physics);
        sb.append(", chemistry=").append(chemistry);
        sb.append(", content1=").append(content1);
        sb.append(", content2=").append(content2);
        sb.append(", content3=").append(content3);
        sb.append(", content5=").append(content5);
        sb.append(", content4=").append(content4);
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
        NrcGrade other = (NrcGrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNrcExamId() == null ? other.getNrcExamId() == null : this.getNrcExamId().equals(other.getNrcExamId()))
            && (this.getNrcClassId() == null ? other.getNrcClassId() == null : this.getNrcClassId().equals(other.getNrcClassId()))
            && (this.getTear() == null ? other.getTear() == null : this.getTear().equals(other.getTear()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMath() == null ? other.getMath() == null : this.getMath().equals(other.getMath()))
            && (this.getChiness() == null ? other.getChiness() == null : this.getChiness().equals(other.getChiness()))
            && (this.getEnglish() == null ? other.getEnglish() == null : this.getEnglish().equals(other.getEnglish()))
            && (this.getPhysics() == null ? other.getPhysics() == null : this.getPhysics().equals(other.getPhysics()))
            && (this.getChemistry() == null ? other.getChemistry() == null : this.getChemistry().equals(other.getChemistry()))
            && (this.getContent1() == null ? other.getContent1() == null : this.getContent1().equals(other.getContent1()))
            && (this.getContent2() == null ? other.getContent2() == null : this.getContent2().equals(other.getContent2()))
            && (this.getContent3() == null ? other.getContent3() == null : this.getContent3().equals(other.getContent3()))
            && (this.getContent5() == null ? other.getContent5() == null : this.getContent5().equals(other.getContent5()))
            && (this.getContent4() == null ? other.getContent4() == null : this.getContent4().equals(other.getContent4()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNrcExamId() == null) ? 0 : getNrcExamId().hashCode());
        result = prime * result + ((getNrcClassId() == null) ? 0 : getNrcClassId().hashCode());
        result = prime * result + ((getTear() == null) ? 0 : getTear().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMath() == null) ? 0 : getMath().hashCode());
        result = prime * result + ((getChiness() == null) ? 0 : getChiness().hashCode());
        result = prime * result + ((getEnglish() == null) ? 0 : getEnglish().hashCode());
        result = prime * result + ((getPhysics() == null) ? 0 : getPhysics().hashCode());
        result = prime * result + ((getChemistry() == null) ? 0 : getChemistry().hashCode());
        result = prime * result + ((getContent1() == null) ? 0 : getContent1().hashCode());
        result = prime * result + ((getContent2() == null) ? 0 : getContent2().hashCode());
        result = prime * result + ((getContent3() == null) ? 0 : getContent3().hashCode());
        result = prime * result + ((getContent5() == null) ? 0 : getContent5().hashCode());
        result = prime * result + ((getContent4() == null) ? 0 : getContent4().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}