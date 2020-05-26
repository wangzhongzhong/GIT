package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcRole;
import com.dnt.cloud.student.model.NrcRoleCriteria;

import java.util.List;

public interface NrcRoleDAO {
    int deleteByExample(NrcRoleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcRole record);

    int insertSelective(NrcRole record);

    List<NrcRole> selectByExample(NrcRoleCriteria example);

    NrcRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcRole record);

    int updateByPrimaryKey(NrcRole record);
}