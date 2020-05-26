package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcTeachClass;
import com.dnt.cloud.student.model.NrcTeachClassCriteria;

import java.util.List;

public interface NrcTeachClassDAO {
    int deleteByExample(NrcTeachClassCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcTeachClass record);

    int insertSelective(NrcTeachClass record);

    List<NrcTeachClass> selectByExample(NrcTeachClassCriteria example);

    NrcTeachClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcTeachClass record);

    int updateByPrimaryKey(NrcTeachClass record);
}