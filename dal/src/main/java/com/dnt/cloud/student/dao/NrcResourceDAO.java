package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcResource;
import com.dnt.cloud.student.model.NrcResourceCriteria;

import java.util.List;

public interface NrcResourceDAO {
    int deleteByExample(NrcResourceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcResource record);

    int insertSelective(NrcResource record);

    List<NrcResource> selectByExample(NrcResourceCriteria example);

    NrcResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcResource record);

    int updateByPrimaryKey(NrcResource record);
}