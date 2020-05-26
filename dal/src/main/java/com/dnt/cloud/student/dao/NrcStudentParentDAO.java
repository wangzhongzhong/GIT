package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcStudentParent;
import com.dnt.cloud.student.model.NrcStudentParentCriteria;

import java.util.List;

public interface NrcStudentParentDAO {
    int deleteByExample(NrcStudentParentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcStudentParent record);

    int insertSelective(NrcStudentParent record);

    List<NrcStudentParent> selectByExample(NrcStudentParentCriteria example);

    NrcStudentParent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcStudentParent record);

    int updateByPrimaryKey(NrcStudentParent record);
}