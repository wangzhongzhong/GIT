/**
 * 
 */
package com.dnt.cloud.student.web.integration;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcClassMateDomain;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.query.NrcClassMateQuery;
import com.dnt.cloud.student.service.NrcClassMateService;
import com.dnt.cloud.student.service.NrcTeachService;
import com.dnt.cloud.student.web.domain.NrcDataDomain;

/**
 * @author julio
 *
 */
@RequestMapping("/classMateData")
@RestController
public class NrcClassMateDataAction {
	
	@Autowired
	private NrcClassMateService nrcClassMateService;
	
	@Autowired
	private NrcTeachService nrcTeachService;
	
	/**
	 * 查询班级信息
	 * @param query
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryNrcClassMate")
	public NrcDataDomain queryNrcClassMate(NrcClassMateQuery query,@RequestParam("page") int page,
			@RequestParam("limit")int limit){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		query.setPageNum(page);
		query.setPageSize(limit);
		PageData<NrcClassMateDomain> pageData = nrcClassMateService.queryNrcClassMateDomain(query);
		if (pageData != null) {
			List<NrcClassMateDomain> list = pageData.getList();
			if (!CollectionUtils.isEmpty(list)) {
				result.setData(list);
				result.setCount(pageData.getTotal());
				result.setMsg("查询成功！");
			}else{
				result.setMsg("查询班级数据不存在！");
			}
			result.setMsg("查询班级数据不存在！");
		}
		return result;
	}

	/**
	 * 保存班级信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/saveNrcClassMate")
	public NrcDataDomain saveNrcClassMate(NrcClassMateDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		NrcTeachDomain teachDomain = nrcTeachService.queryNrcTeachById(domain.getTeachId());
		if (teachDomain != null) {
			domain.setTeachName(teachDomain.getName());
		}
		boolean saveResult = nrcClassMateService.save(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}
	
	/**
	 * 更新班级信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/updateNrcClassMate")
	public NrcDataDomain updateNrcClassMate(NrcClassMateDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		NrcTeachDomain teachDomain = nrcTeachService.queryNrcTeachById(domain.getTeachId());
		if (teachDomain != null) {
			domain.setTeachName(teachDomain.getName());
		}
		boolean saveResult = nrcClassMateService.update(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}
}
