/**
 * 
 */
package com.dnt.cloud.student.service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcClassMateDomain;
import com.dnt.cloud.student.query.NrcClassMateQuery;

/**
 * @author julio
 *
 */
public interface NrcClassMateService {
	
	/**
	 * 保存
	 * @param domain
	 * @return
	 */
	boolean save(NrcClassMateDomain domain);
	
	/**
	 * 更新
	 * @param domain
	 * @return
	 */
	boolean update(NrcClassMateDomain domain);
	
	/**
	 * 查询指定条件下的班级信息
	 * @param query
	 * @return
	 */
	PageData<NrcClassMateDomain> queryNrcClassMateDomain(NrcClassMateQuery query);
	
	/**
	 * 查询指定id下面的班级信息
	 * @param id
	 * @return
	 */
	NrcClassMateDomain queryNrcClassMateById(Long id);

}
