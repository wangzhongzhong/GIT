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
import com.dnt.cloud.student.dao.NrcStudentDAO;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.model.NrcStudent;
import com.dnt.cloud.student.model.NrcStudentCriteria;
import com.dnt.cloud.student.query.NrcStudentQuery;
import com.dnt.cloud.student.service.NrcStudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author julio
 *
 */
@Service
public class NrcStudentServiceImpl implements NrcStudentService {
	
	@Autowired
	private NrcStudentDAO nrcStudentDAO;

	@Override
	public boolean save(NrcStudentDomain domain) {
		int lef = nrcStudentDAO.insertSelective(this.conver2Model(domain));
		return lef == 1? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcStudentService#update(com.dnt.cloud.student.domain.NrcStudentDomain)
	 */
	@Override
	public boolean update(NrcStudentDomain domain) {
		int lef = nrcStudentDAO.updateByPrimaryKeySelective(this.conver2Model(domain));
		return lef == 1? true : false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcStudentService#queryNrcStudentDomain(com.dnt.cloud.student.query.NrcStudentQuery)
	 */
	@Override
	public PageData<NrcStudentDomain> queryNrcStudentDomain(
			NrcStudentQuery query) {
		NrcStudentCriteria example = new NrcStudentCriteria();
		NrcStudentCriteria.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(query.getName())) {
			criteria.andNameEqualTo(query.getName());
		}
		if (StringUtil.isNotBlank(query.getStudentNo())) {
			criteria.andStudentNoLike(query.getStudentNo());
		}
		if (query.getNrcClassId() != null) {
			criteria.andNrcClassIdEqualTo(query.getNrcClassId());
		}
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.getOrderBy());
		Page<NrcStudent> page = (Page<NrcStudent>) nrcStudentDAO.selectByExample(example);
		if (CollectionUtils.isEmpty(page)) {
			return null;
		}
		List<NrcStudentDomain> list = new ArrayList<NrcStudentDomain>();
		page.forEach(data ->{
			list.add(this.conver2Domain(data));
		});
		return new PageData<>(list, page.getTotal(), query.getPageNum(), query.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcStudentService#queryNrcStudentById(java.lang.Long)
	 */
	@Override
	public NrcStudentDomain queryNrcStudentById(Long id) {
		NrcStudent nrcStudent = nrcStudentDAO.selectByPrimaryKey(id);
		return nrcStudent == null ? null : this.conver2Domain(nrcStudent);
	}
	
	private NrcStudent conver2Model(NrcStudentDomain source) {
		if (source == null) {
			return null;
		}

		NrcStudent target = new NrcStudent();
		BeanUtils.copyProperties(source, target, "gmtCreate", "gmtModify");
		return target;
	}

	private NrcStudentDomain conver2Domain(NrcStudent source) {
		if (source == null) {
			return null;
		}

		NrcStudentDomain target = new NrcStudentDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
