/**
 * 
 */
package com.dnt.cloud.student.service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.query.NrcStudentQuery;

/**
 * @author julio
 *
 */
public interface NrcStudentService {
	
	/**
	 * 保存
	 * @param domain
	 * @return
	 */
	boolean save(NrcStudentDomain domain);
	
	/**
	 * 更新
	 * @param domain
	 * @return
	 */
	boolean update(NrcStudentDomain domain);
	
	/**
	 * 查询学生信息
	 * @param query
	 * @return
	 */
	PageData<NrcStudentDomain> queryNrcStudentDomain(NrcStudentQuery query);
	
	/**
	 * 查询指定id的学生信息
	 * @param id
	 * @return
	 */
	NrcStudentDomain queryNrcStudentById(Long id);
	
}
