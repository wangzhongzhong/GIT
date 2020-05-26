package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcClassMate;
import com.dnt.cloud.student.model.NrcClassMateCriteria;
import java.util.List;

public interface NrcClassMateDAO {
    int deleteByExample(NrcClassMateCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcClassMate record);

    int insertSelective(NrcClassMate record);

    List<NrcClassMate> selectByExample(NrcClassMateCriteria example);

    NrcClassMate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcClassMate record);

    int updateByPrimaryKey(NrcClassMate record);
}