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
import com.dnt.cloud.student.dao.NrcTeachDAO;
import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.domain.NrcUserDomain;
import com.dnt.cloud.student.model.NrcTeach;
import com.dnt.cloud.student.model.NrcTeachCriteria;
import com.dnt.cloud.student.model.NrcUser;
import com.dnt.cloud.student.query.NrcTeachQuery;
import com.dnt.cloud.student.service.NrcTeachService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author julio
 *
 */
@Service
public class NrcTeachServiceImpl implements NrcTeachService {
	
	@Autowired
	private NrcTeachDAO nrcTeachDAO;

	@Override
	public boolean save(NrcTeachDomain nrcTeachDomain) {
		int lef = nrcTeachDAO.insertSelective(this.conver2Model(nrcTeachDomain));
		return lef == 1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcTeachService#update(com.dnt.cloud.student.domain.NrcTeachDomain)
	 */
	@Override
	public boolean update(NrcTeachDomain nrcTeachDomain) {
		int lef = nrcTeachDAO.updateByPrimaryKeySelective(this.conver2Model(nrcTeachDomain));
		return lef == 1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcTeachService#queryNrcTeachDomain(com.dnt.cloud.student.query.NrcTeachQuery)
	 */
	@Override
	public PageData<NrcTeachDomain> queryNrcTeachDomain(NrcTeachQuery query) {
		NrcTeachCriteria criteria = new NrcTeachCriteria();
		NrcTeachCriteria.Criteria example = criteria.createCriteria();
		if (StringUtil.isNotBlank(query.getName())) {
			example.andNameLike(query.getName());
		}
		if (StringUtil.isNotBlank(query.getMobile())) {
			example.andMobileEqualTo(query.getMobile());
		}
		if (StringUtil.isNotBlank(query.getSubject())) {
			example.andSubjectLike(query.getSubject());
		}
		if (StringUtil.isNotBlank(query.getType())) {
			example.andTypeEqualTo(query.getType());
		}
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.getOrderBy());
		Page<NrcTeach> page = (Page<NrcTeach>) nrcTeachDAO.selectByExample(criteria);
		if (CollectionUtils.isEmpty(page)) {
			return null;
		}
		List<NrcTeachDomain> list = new ArrayList<>();
		page.forEach(data ->{
			list.add(this.conver2Domain(data));
		});
		return new PageData<>(list, page.getTotal(), query.getPageNum(), query.getPageSize());
	}
	
	@Override
	public NrcTeachDomain queryNrcTeachById(Long id) {
		NrcTeach teach = nrcTeachDAO.selectByPrimaryKey(id);
		return teach == null ? null : this.conver2Domain(teach);
	}
	
	private NrcTeach conver2Model(NrcTeachDomain source) {
		if (source == null) {
			return null;
		}

		NrcTeach target = new NrcTeach();
		BeanUtils.copyProperties(source, target, "gmtCreate", "gmtModify");
		return target;
	}

	private NrcTeachDomain conver2Domain(NrcTeach source) {
		if (source == null) {
			return null;
		}

		NrcTeachDomain target = new NrcTeachDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
