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
import com.dnt.cloud.student.enums.NrcTeachTypeEnum;
import com.dnt.cloud.student.query.NrcStudentQuery;
import com.dnt.cloud.student.service.NrcClassMateService;
import com.dnt.cloud.student.service.NrcStudentService;
import com.dnt.cloud.student.web.domain.NrcDataDomain;

/**
 * @author julio
 *
 */
@RequestMapping("/studentData")
@RestController
public class NrcStudentDataAction {
	
	@Autowired
	private NrcStudentService nrcStudentService;
	
	@Autowired
	private NrcClassMateService nrcClassMateService;
	
	/**
	 * 查询学生信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/queryNrcStudentList")
	public NrcDataDomain queryNrcStudentList(NrcStudentQuery query,@RequestParam("page") int page,
			@RequestParam("limit")int limit){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		query.setPageNum(page);
		query.setPageSize(limit);
		PageData<NrcStudentDomain> pageData = nrcStudentService.queryNrcStudentDomain(query);
		if (pageData != null) {
			List<NrcStudentDomain> list = pageData.getList();
			if (!CollectionUtils.isEmpty(list)) {
				NrcClassMateDomain domain = null;
				for (NrcStudentDomain nrcStudentDomain : list) {
					domain = nrcClassMateService.queryNrcClassMateById(nrcStudentDomain.getNrcClassId());
					nrcStudentDomain.setNrcClassName(domain.getName());
				}
				result.setData(list);
				result.setCount(pageData.getTotal());
				result.setMsg("查询成功！");
			}else{
				result.setMsg("查询学生数据不存在！");
			}
			result.setMsg("查询学生数据不存在！");
		}
		return result;
	}
	
	/**
	 * 保存学生信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/saveNrcStudent")
	public NrcDataDomain saveNrcStudent(NrcStudentDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcStudentService.save(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}
	
	/**
	 * 更新学生信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/updateNrcStudent")
	public NrcDataDomain updateNrcStudent(NrcStudentDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcStudentService.update(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}

}
