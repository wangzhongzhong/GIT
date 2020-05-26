/**
 * 
 */
package com.dnt.cloud.student.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.dao.NrcUserDAO;
import com.dnt.cloud.student.domain.NrcUserDomain;
import com.dnt.cloud.student.model.NrcUser;
import com.dnt.cloud.student.model.NrcUserCriteria;
import com.dnt.cloud.student.query.NrcUserQuery;
import com.dnt.cloud.student.service.NrcUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author julio
 *
 */
@Service
public class NrcUserServiceImpl implements NrcUserService {
	
	@Autowired
	private NrcUserDAO nrcUserDAO;

	@Override
	public boolean save(NrcUserDomain userDomain) {
		int lef = nrcUserDAO.insertSelective(this.conver2Model(userDomain));
		return lef == 1 ? true : false;
	}

	@Override
	public boolean update(NrcUserDomain userDomain) {
		int lef = nrcUserDAO.updateByPrimaryKeySelective(this.conver2Model(userDomain));
		return lef == 1 ? true : false;
	}

	@Override
	public NrcUserDomain selectNrcUserDomainbyId(Long id) {
		NrcUser nrcUser = nrcUserDAO.selectByPrimaryKey(id);
		return nrcUser == null ? null : this.conver2Domain(nrcUser);
	}

	@Override
	public NrcUserDomain login(String loginName, String pwd) {
		NrcUser user = nrcUserDAO.login(loginName,pwd);
		return user == null ? null : this.conver2Domain(user);
	}

	@Override
	public boolean resetUserPwd(Long userId, String pwd) {
		int lef = nrcUserDAO.restUserPwd(userId,pwd);
		return lef == 1 ? true : false;
	}

	@Override
	public boolean updateNrcUserPwd(Long userId, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.dnt.cloud.student.service.NrcUserService#queryNrcUserAuditRole(java.lang.Long, java.lang.String)
	 */
	@Override
	public NrcUserDomain queryNrcUserAuditRole(Long nrcUserId,
			String invoiceAuditUrl) {
		NrcUser nrcUser = nrcUserDAO.queryNrcUserAuditRole(nrcUserId,invoiceAuditUrl);
		return nrcUser == null ? null : this.conver2Domain(nrcUser);
	}
	
	@Override
	public PageData<NrcUserDomain> selectNrcUserDomain(NrcUserQuery query) {
		NrcUserCriteria example = new NrcUserCriteria();
		NrcUserCriteria.Criteria criteria = example.createCriteria();
		if (query.getId() != null) {
			criteria.andIdEqualTo(query.getId());
		}
		if (StringUtil.isNotBlank(query.getLoginName())) {
			criteria.andLoginNameEqualTo(query.getLoginName());
		}
		if (StringUtil.isNotBlank(query.getName())) {
			criteria.andNameEqualTo(query.getName());
		}
		if (StringUtil.isNotBlank(query.getEmail())) {
			criteria.andEmailEqualTo(query.getEmail());
		}
		if (StringUtil.isNotBlank(query.getOrderBy())) {
			example.setOrderByClause(query.getOrderBy());
		}
		if (query.getGmtCreate() != null) {
			if (query.getGmtModify() != null) {
				criteria.andGmtCreateBetween(query.getGmtCreate(), query.getGmtModify());
			}else{
				criteria.andGmtCreateBetween(query.getGmtCreate(), new Date());
			}
		}
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.getOrderBy());
		Page<NrcUser> page = (Page<NrcUser>) nrcUserDAO.selectByExample(example);
		if (CollectionUtils.isEmpty(page)) {
			return null;
		}
		List<NrcUserDomain> list = new ArrayList<>();
		page.forEach(data ->{
			list.add(this.conver2Domain(data));
		});
		return new PageData<NrcUserDomain>(list, page.getTotal(), page.getPageNum(), page.getPageSize());
	}

	private NrcUser conver2Model(NrcUserDomain source) {
		if (source == null) {
			return null;
		}

		NrcUser target = new NrcUser();
		BeanUtils.copyProperties(source, target, "gmtCreate", "gmtModify");
		return target;
	}

	private NrcUserDomain conver2Domain(NrcUser source) {
		if (source == null) {
			return null;
		}

		NrcUserDomain target = new NrcUserDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
