/**
 * 
 */
package com.dnt.cloud.student.service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.query.NrcTeachQuery;

/**
 * @author julio
 *
 */
public interface NrcTeachService {
	
	/**
	 * 保存
	 * @param nrcTeachDomain
	 * @return
	 */
	boolean save(NrcTeachDomain nrcTeachDomain);
	
	/**
	 * 更新
	 * @param nrcTeachDomain
	 * @return
	 */
	boolean update(NrcTeachDomain nrcTeachDomain);
	
	/**
	 * 查询老师数据
	 * @param query
	 * @return
	 */
	PageData<NrcTeachDomain> queryNrcTeachDomain(NrcTeachQuery query);
	
	/**
	 * 查询指定id的老师数据
	 * @param id
	 * @return
	 */
	NrcTeachDomain queryNrcTeachById(Long id);

}
