package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcRoleResouce;
import com.dnt.cloud.student.model.NrcRoleResouceCriteria;

import java.util.List;

public interface NrcRoleResouceDAO {
    int deleteByExample(NrcRoleResouceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcRoleResouce record);

    int insertSelective(NrcRoleResouce record);

    List<NrcRoleResouce> selectByExample(NrcRoleResouceCriteria example);

    NrcRoleResouce selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcRoleResouce record);

    int updateByPrimaryKey(NrcRoleResouce record);
}