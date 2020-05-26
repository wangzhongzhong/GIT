/*
 * netfinworks.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.dnt.cloud.student.query;

import com.dnt.cloud.common.domain.query.PageQuery;

public class NrcOfficialAccountQuery extends PageQuery {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8298683898035242277L;
	private Long id;
    private String attension;
    private String bottomMenu;
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
		this.attension = attension;
	}
	
	public String getBottomMenu() {
		return bottomMenu;
	}

	public void setBottomMenu(String bottomMenu) {
		this.bottomMenu = bottomMenu;
	}
	
}
