/*
 * netfinworks.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.dnt.cloud.student.query;

import com.dnt.cloud.common.domain.query.PageQuery;

public class NrcExamQuery extends PageQuery {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2790891400773756953L;
	private Long id;
    private String name;
    private String time;
    private Long nrcClassId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Long getNrcClassId() {
		return nrcClassId;
	}

	public void setNrcClassId(Long nrcClassId) {
		this.nrcClassId = nrcClassId;
	}
	
}
