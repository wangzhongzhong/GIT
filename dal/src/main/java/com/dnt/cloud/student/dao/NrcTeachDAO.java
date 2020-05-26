package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcTeach;
import com.dnt.cloud.student.model.NrcTeachCriteria;

import java.util.List;

public interface NrcTeachDAO {
    int deleteByExample(NrcTeachCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcTeach record);

    int insertSelective(NrcTeach record);

    List<NrcTeach> selectByExample(NrcTeachCriteria example);

    NrcTeach selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcTeach record);

    int updateByPrimaryKey(NrcTeach record);
}