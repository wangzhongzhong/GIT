/**
 * 
 */
package com.dnt.cloud.student.web.action;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dnt.cloud.student.domain.NrcExamDomain;
import com.dnt.cloud.student.service.NrcExamService;

/**
 * @author julio
 *
 */
@RequestMapping("/exam")
@Controller
public class NrcExamAction {
	
	private final String EXAM_QUERY = "/nrcExam/queryExam";
	
	private final String EXAM_SAVE = "/nrcExam/saveExam";
	
	private final String EXAM_VIEW = "/nrcExam/viewExam";
	
	@Autowired
	private NrcExamService nrcExamService;
	
	/**
	 * 查询考试信息
	 * @return
	 */
	@RequestMapping("/queryNrcExam")
	public ModelAndView queryNrcExamList(){
		return new ModelAndView(EXAM_QUERY);
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("/svaeNrcExam")
	public ModelAndView saveNrcExam(){
		return new ModelAndView(EXAM_SAVE);
	}
	
	/**
	 * 跳转到查看页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/viewNrcExam")
	public ModelAndView viewNrcExam(ModelMap map,Long id){
		NrcExamDomain nrcExamDomain = nrcExamService.queryById(id);
		if (nrcExamDomain != null) {
			map.put("result", nrcExamDomain);
		}
		return new ModelAndView(EXAM_VIEW);
	}

}
