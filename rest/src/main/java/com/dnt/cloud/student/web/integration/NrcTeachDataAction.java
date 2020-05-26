/**
 * 
 */
package com.dnt.cloud.student.web.integration;

import java.util.List;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.enums.NrcTeachTypeEnum;
import com.dnt.cloud.student.query.NrcTeachQuery;
import com.dnt.cloud.student.service.NrcTeachService;
import com.dnt.cloud.student.web.domain.NrcDataDomain;

/**
 * @author julio
 *
 */
@RequestMapping("/teachData")
@RestController
public class NrcTeachDataAction {
	
	@Autowired
	private NrcTeachService nrcTeachService;
	
	/**
	 * 插叙老师信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/queryNrcTeachList")
	public NrcDataDomain queryNrcTeachList(NrcTeachQuery query,@RequestParam("page") int page,
			@RequestParam("limit")int limit){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		query.setPageNum(page);
		query.setPageSize(limit);
		PageData<NrcTeachDomain> pageData = nrcTeachService.queryNrcTeachDomain(query);
		if (pageData != null) {
			List<NrcTeachDomain> list = pageData.getList();
			if (!CollectionUtils.isEmpty(list)) {
				list.forEach(data ->{
					data.setType(NrcTeachTypeEnum.getByCode(data.getType()).getMessage());
				});
				result.setData(list);
				result.setCount(pageData.getTotal());
				result.setMsg("查询成功！");
			}else{
				result.setMsg("查询老师数据不存在！");
			}
			result.setMsg("查询老师数据不存在！");
		}
		return result;
		
	}
	
	/**
	 * 保存老师信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/saveNrcTeach")
	public NrcDataDomain saveNrcTeach(NrcTeachDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcTeachService.save(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}
	
	/**
	 * 更新老师信息
	 * @param domain
	 * @return
	 */
	@PostMapping("/updateNrcTeach")
	public NrcDataDomain updateNrcTeach(NrcTeachDomain domain){
		NrcDataDomain result = new NrcDataDomain();
		result.setCode(0);
		boolean saveResult = nrcTeachService.update(domain);
		if (saveResult) {
			result.setMsg("true");
		}else{
			result.setMsg("false");
		}
		return result;
	}

}
