/**
 * 
 */
package com.dnt.cloud.student.service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcUserDomain;
import com.dnt.cloud.student.query.NrcUserQuery;

/**
 * @author julio
 *
 */
public interface NrcUserService {
	
	/**
	 * 保存用户
	 * @param userDomain
	 * @return
	 */
	boolean save(NrcUserDomain userDomain);
	
	/**
	 * 更新用户
	 * @param userDomain
	 * @return
	 */
	boolean update(NrcUserDomain userDomain);
	
	/**
	 * 查询指定用户id的用户信息
	 * @param id
	 * @return
	 */
	NrcUserDomain selectNrcUserDomainbyId(Long id);
	
	/**
	 * 用户登录
	 * @param loginName
	 * @param pwd
	 * @return
	 */
	NrcUserDomain login(String loginName,String pwd);
	
	/**
	 * 重置用户密码
	 * @param userId
	 * @param pwd
	 * @return
	 */
	boolean resetUserPwd(Long userId,String pwd);
	
	/**
	 * 用户修改密码
	 * @param userId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	boolean updateNrcUserPwd(Long userId, String oldPwd, String newPwd);
	
	/**
	 * 查询指定用户id，对应的路径是否有该权限
	 * @param nrcUserId
	 * @param invoiceAuditUrl
	 * @return
	 */
	NrcUserDomain queryNrcUserAuditRole(Long nrcUserId, String invoiceAuditUrl);
	
	/**
	 * 查询用户信息
	 * @param query
	 * @return
	 */
	PageData<NrcUserDomain> selectNrcUserDomain(NrcUserQuery query);
	
}
