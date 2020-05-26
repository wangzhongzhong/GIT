/**
 * 
 */
package com.dnt.cloud.student.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.domain.NrcClassMateDomain;
import com.dnt.cloud.student.domain.NrcStudentDomain;
import com.dnt.cloud.student.query.NrcClassMateQuery;
import com.dnt.cloud.student.service.NrcClassMateService;
import com.dnt.cloud.student.service.NrcStudentService;

/**
 * @author julio
 *
 */
@RequestMapping("/student")
@Controller
public class NrcStudentAction {
	
	private final String STUDENT_QUERY = "/nrcStudent/queryStudent";
	
	private final String STUDENT_SAVE = "/nrcStudent/saveStudent";
	
	private final String STUDENT_VIEW = "/nrcStudent/viewStudent";
	
	@Autowired
	private NrcStudentService nrcStudentService;
	
	@Autowired
	private NrcClassMateService nrcClassMateService;
	
	/**
	 * 查询学生信息
	 * @return
	 */
	@RequestMapping("/queryNrcStudentList")
	public ModelAndView queryNrcStudentList(ModelMap map){
		NrcClassMateQuery query = new NrcClassMateQuery();
		query.setPageNum(1);
		query.setPageSize(0);
		PageData<NrcClassMateDomain> classMatePage = nrcClassMateService.queryNrcClassMateDomain(query);
		if (classMatePage != null) {
			List<NrcClassMateDomain> list = classMatePage.getList();
			if (!CollectionUtils.isEmpty(list)) {
				map.put("classMateList", list);
			}
		}
		return new ModelAndView(STUDENT_QUERY);
	}
	
	/**
	 * 更新学生
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/viewNrcStudent")
	public ModelAndView viewNrcStudent(Long id,ModelMap map){
		NrcStudentDomain studentDomain = nrcStudentService.queryNrcStudentById(id);
		if (studentDomain != null) {
			map.put("result", studentDomain);
		}
		NrcClassMateQuery query = new NrcClassMateQuery();
		query.setPageNum(1);
		query.setPageSize(0);
		PageData<NrcClassMateDomain> classMatePage = nrcClassMateService.queryNrcClassMateDomain(query);
		if (classMatePage != null) {
			List<NrcClassMateDomain> list = classMatePage.getList();
			if (!CollectionUtils.isEmpty(list)) {
				map.put("classMateList", list);
			}
		}
		return new ModelAndView(STUDENT_VIEW);
	}
	
	/**
	 * 新增学生
	 * @return
	 */
	@RequestMapping("/saveNrcStudent")
	public ModelAndView saveNrcStudent(ModelMap map){
		NrcClassMateQuery query = new NrcClassMateQuery();
		query.setPageNum(1);
		query.setPageSize(0);
		PageData<NrcClassMateDomain> classMatePage = nrcClassMateService.queryNrcClassMateDomain(query);
		if (classMatePage != null) {
			List<NrcClassMateDomain> list = new ArrayList<NrcClassMateDomain>();
			if (!CollectionUtils.isEmpty(list)) {
				map.put("classMateList", list);
			}
		}
		return new ModelAndView(STUDENT_SAVE);
	}

}
