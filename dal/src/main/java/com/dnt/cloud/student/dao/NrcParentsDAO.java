package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcParents;
import com.dnt.cloud.student.model.NrcParentsCriteria;
import java.util.List;

public interface NrcParentsDAO {
    int deleteByExample(NrcParentsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcParents record);

    int insertSelective(NrcParents record);

    List<NrcParents> selectByExample(NrcParentsCriteria example);

    NrcParents selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcParents record);

    int updateByPrimaryKey(NrcParents record);
}