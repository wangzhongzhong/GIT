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
import com.dnt.cloud.student.dao.NrcClassMateDAO;
import com.dnt.cloud.student.domain.NrcClassMateDomain;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.model.NrcClassMate;
import com.dnt.cloud.student.model.NrcClassMateCriteria;
import com.dnt.cloud.student.model.NrcStudent;
import com.dnt.cloud.student.query.NrcClassMateQuery;
import com.dnt.cloud.student.service.NrcClassMateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author julio
 *
 */
@Service
public class NrcClassMateServiceImpl implements NrcClassMateService {
	
	@Autowired
	private NrcClassMateDAO nrcClassMateDAO;

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcClassMateService#save(com.dnt.cloud.student.domain.NrcClassMateDomain)
	 */
	@Override
	public boolean save(NrcClassMateDomain domain) {
		int lef = nrcClassMateDAO.insert(this.conver2Model(domain));
		return lef == 1 ? true :false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcClassMateService#update(com.dnt.cloud.student.domain.NrcClassMateDomain)
	 */
	@Override
	public boolean update(NrcClassMateDomain domain) {
		int lef = nrcClassMateDAO.updateByPrimaryKey(this.conver2Model(domain));
		return lef == 1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcClassMateService#queryNrcClassMateDomain(com.dnt.cloud.student.query.NrcClassMateQuery)
	 */
	@Override
	public PageData<NrcClassMateDomain> queryNrcClassMateDomain(
			NrcClassMateQuery query) {
		NrcClassMateCriteria example = new NrcClassMateCriteria();
		NrcClassMateCriteria.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(query.getName())) {
			criteria.andNameEqualTo(query.getName());
		}
		if (StringUtil.isNotBlank(query.getPeriod())) {
			criteria.andPeriodEqualTo(query.getPeriod());
		}
		if (StringUtil.isNotBlank(query.getTeachName())) {
			criteria.andTeachNameEqualTo(query.getTeachName());
		}
		if (query.getTeachId() != null) {
			criteria.andTeachIdEqualTo(query.getTeachId());
		}
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.getOrderBy());
		Page<NrcClassMate> page = (Page<NrcClassMate>) nrcClassMateDAO.selectByExample(example);
		if (CollectionUtils.isEmpty(page)) {
			return null;
		}
		List<NrcClassMateDomain> list = new ArrayList<NrcClassMateDomain>();
		page.forEach(data ->{
			list.add(this.conver2Domain(data));
		});
		return new PageData<>(list, page.getTotal(), query.getPageNum(), query.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcClassMateService#queryNrcClassMateById(java.lang.Long)
	 */
	@Override
	public NrcClassMateDomain queryNrcClassMateById(Long id) {
		NrcClassMate classMate = nrcClassMateDAO.selectByPrimaryKey(id);
		return classMate == null ? null : this.conver2Domain(classMate);
	}
	
	private NrcClassMate conver2Model(NrcClassMateDomain source) {
		if (source == null) {
			return null;
		}

		NrcClassMate target = new NrcClassMate();
		BeanUtils.copyProperties(source, target, "gmtCreate", "gmtModify");
		return target;
	}

	private NrcClassMateDomain conver2Domain(NrcClassMate source) {
		if (source == null) {
			return null;
		}

		NrcClassMateDomain target = new NrcClassMateDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
