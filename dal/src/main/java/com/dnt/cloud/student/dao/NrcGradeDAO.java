package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcGrade;
import com.dnt.cloud.student.model.NrcGradeCriteria;
import java.util.List;

public interface NrcGradeDAO {
    int deleteByExample(NrcGradeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcGrade record);

    int insertSelective(NrcGrade record);

    List<NrcGrade> selectByExample(NrcGradeCriteria example);

    NrcGrade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcGrade record);

    int updateByPrimaryKey(NrcGrade record);
}