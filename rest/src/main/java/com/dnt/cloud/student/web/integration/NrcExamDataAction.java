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
import com.dnt.cloud.student.domain.NrcExamDomain;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.query.NrcExamQuery;
import com.dnt.cloud.student.service.NrcExamService;
import com.dnt.cloud.student.web.domain.NrcDataDomain;

/**
 * @author julio
 *
 */
@RequestMapping("/examData")
@RestController
public class NrcExamDataAction {
	
	@Autowired
	private NrcExamService nrcExamService;
	
	/**
	 * 查询学生信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/queryNrcExamList")
	public NrcDataDomain queryNrcExamList(NrcExamQuery query,@RequestParam("page") int page,
			@RequestParam("limit")int limit){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		query.setPageNum(page);
		query.setPageSize(limit);
		PageData<NrcExamDomain> pageData = nrcExamService.query(query);
		if (pageData != null) {
			List<NrcExamDomain> list = pageData.getList();
			if (!CollectionUtils.isEmpty(list)) {
				result.setData(list);
				result.setCount(pageData.getTotal());
				result.setMsg("查询成功！");
			}else{
				result.setMsg("查询考试数据不存在！");
			}
			result.setMsg("查询考试数据不存在！");
		}
		return result;
	}
	
	/**
	 * 保存考试信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/saveNrcExam")
	public NrcDataDomain saveNrcExam(NrcExamDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcExamService.save(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}
	
	/**
	 * 更新考试信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/updateNrcExam")
	public NrcDataDomain updateNrcExam(NrcExamDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcExamService.update(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}

}
