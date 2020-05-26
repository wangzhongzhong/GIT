package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcStudent;
import com.dnt.cloud.student.model.NrcStudentCriteria;

import java.util.List;

public interface NrcStudentDAO {
    int deleteByExample(NrcStudentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcStudent record);

    int insertSelective(NrcStudent record);

    List<NrcStudent> selectByExample(NrcStudentCriteria example);

    NrcStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcStudent record);

    int updateByPrimaryKey(NrcStudent record);
}