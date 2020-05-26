/**
 * 
 */
package com.dnt.cloud.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.dao.NrcExamDAO;
import com.dnt.cloud.student.domain.NrcExamDomain;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.model.NrcExam;
import com.dnt.cloud.student.model.NrcExamCriteria;
import com.dnt.cloud.student.model.NrcStudent;
import com.dnt.cloud.student.query.NrcExamQuery;
import com.dnt.cloud.student.service.NrcExamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author julio
 *
 */
@Service
public class NrcExamServiceImpl implements NrcExamService {

	@Autowired
	private NrcExamDAO nrcExamDAO;
	
	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcExamService#save(com.dnt.cloud.student.domain.NrcExamDomain)
	 */
	@Override
	public boolean save(NrcExamDomain domain) {
		int lef = nrcExamDAO.insert(this.conver2Model(domain));
		return lef == 1? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcExamService#update(com.dnt.cloud.student.domain.NrcExamDomain)
	 */
	@Override
	public boolean update(NrcExamDomain domain) {
		int lef = nrcExamDAO.updateByPrimaryKey(this.conver2Model(domain));
		return lef ==1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcExamService#query(com.dnt.cloud.student.query.NrcExamQuery)
	 */
	@Override
	public PageData<NrcExamDomain> query(NrcExamQuery query) {
		NrcExamCriteria example = new NrcExamCriteria();
		NrcExamCriteria.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(query.getName())) {
			criteria.andNameEqualTo(query.getName());
		}
		if (StringUtil.isNotBlank(query.getTime())) {
			criteria.andTimeEqualTo(query.getTime());
		}
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.getOrderBy());
		Page<NrcExam> page = (Page<NrcExam>) nrcExamDAO.selectByExample(example);
		if (CollectionUtils.isEmpty(page)) {
			return null;
		}
		List<NrcExamDomain> list = new ArrayList<NrcExamDomain>();
		page.forEach(data ->{
			list.add(this.conver2Domain(data));
		});
		return new PageData<>(list, page.getTotal(), query.getPageNum(), query.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcExamService#queryById(java.lang.Long)
	 */
	@Override
	public NrcExamDomain queryById(Long id) {
		NrcExam exam = nrcExamDAO.selectByPrimaryKey(id);
		return exam == null ? null : this.conver2Domain(exam);
	}
	
	private NrcExam conver2Model(NrcExamDomain source) {
		if (source == null) {
			return null;
		}

		NrcExam target = new NrcExam();
		BeanUtils.copyProperties(source, target, "gmtCreate", "gmtModify");
		return target;
	}

	private NrcExamDomain conver2Domain(NrcExam source) {
		if (source == null) {
			return null;
		}

		NrcExamDomain target = new NrcExamDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
