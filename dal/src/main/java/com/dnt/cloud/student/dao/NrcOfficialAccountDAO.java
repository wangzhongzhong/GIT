package com.dnt.cloud.student.dao;

import com.dnt.cloud.student.model.NrcOfficialAccount;
import com.dnt.cloud.student.model.NrcOfficialAccountCriteria;
import java.util.List;

public interface NrcOfficialAccountDAO {
    int deleteByExample(NrcOfficialAccountCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(NrcOfficialAccount record);

    int insertSelective(NrcOfficialAccount record);

    List<NrcOfficialAccount> selectByExample(NrcOfficialAccountCriteria example);

    NrcOfficialAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NrcOfficialAccount record);

    int updateByPrimaryKey(NrcOfficialAccount record);
}