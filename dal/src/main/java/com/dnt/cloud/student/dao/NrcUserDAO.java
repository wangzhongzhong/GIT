package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcUser;
import com.dnt.cloud.student.model.NrcUserCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NrcUserDAO {
    int deleteByExample(NrcUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcUser record);

    int insertSelective(NrcUser record);

    List<NrcUser> selectByExample(NrcUserCriteria example);

    NrcUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcUser record);

    int updateByPrimaryKey(NrcUser record);

    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    NrcUser login(@Param("loginName") String loginName,@Param("pwd") String pwd);

    /**
     * 重置用户密码
     * @param userId
     * @param pwd
     * @return
     */
	int restUserPwd(@Param("userId") Long userId, @Param("pwd") String pwd);

	/**
	 * 判断当前用户id是否有审核该路径的权限
	 * @param nrcUserId
	 * @param invoiceAuditUrl
	 * @return
	 */
	NrcUser queryNrcUserAuditRole(@Param("userId")Long nrcUserId, 
			@Param("url")String invoiceAuditUrl);
}