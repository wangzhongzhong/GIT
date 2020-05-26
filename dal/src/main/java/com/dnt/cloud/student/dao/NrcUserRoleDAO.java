package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcUserRole;
import com.dnt.cloud.student.model.NrcUserRoleCriteria;

import java.util.List;

public interface NrcUserRoleDAO {
    int deleteByExample(NrcUserRoleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcUserRole record);

    int insertSelective(NrcUserRole record);

    List<NrcUserRole> selectByExample(NrcUserRoleCriteria example);

    NrcUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcUserRole record);

    int updateByPrimaryKey(NrcUserRole record);
}