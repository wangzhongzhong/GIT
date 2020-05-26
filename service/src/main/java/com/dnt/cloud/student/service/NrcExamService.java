/**
 * 
 */
package com.dnt.cloud.student.service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcExamDomain;
import com.dnt.cloud.student.query.NrcExamQuery;

/**
 * @author julio
 *
 */
public interface NrcExamService {
	
	/**
	 * 保存一个考试信息
	 * @param domain
	 * @return
	 */
	boolean save(NrcExamDomain domain);
	
	/**
	 * 更新一个考试信息
	 * @param domain
	 * @return
	 */
	boolean update(NrcExamDomain domain);
	
	/**
	 * 查询考试信息
	 * @param query
	 * @return
	 */
	PageData<NrcExamDomain> query(NrcExamQuery query);
	
	/**
	 * 查询指定id下面的考试信息
	 * @param id
	 * @return
	 */
	NrcExamDomain queryById(Long id);

}
