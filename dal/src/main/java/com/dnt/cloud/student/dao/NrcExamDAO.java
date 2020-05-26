package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcExam;
import com.dnt.cloud.student.model.NrcExamCriteria;
import java.util.List;

public interface NrcExamDAO {
    int deleteByExample(NrcExamCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcExam record);

    int insertSelective(NrcExam record);

    List<NrcExam> selectByExample(NrcExamCriteria example);

    NrcExam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcExam record);

    int updateByPrimaryKey(NrcExam record);
}