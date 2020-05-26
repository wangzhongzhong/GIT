package com.dnt.cloud.student.domain;

import java.util.Date;

import com.dnt.cloud.common.domain.BaseDomain;

public class NrcGradeDomain extends BaseDomain {
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

	public Long getNrcExamId() {
		return nrcExamId;
	}

	public void setNrcExamId(Long nrcExamId) {
		this.nrcExamId = nrcExamId;
	}

}