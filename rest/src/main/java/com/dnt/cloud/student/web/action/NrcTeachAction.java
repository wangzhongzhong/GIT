/**
 * 
 */
package com.dnt.cloud.student.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.service.NrcTeachService;

/**
 * @author julio
 *
 */
@RequestMapping("/teach")
@Controller
public class NrcTeachAction {
	
	private final String QUERY_TEACH = "/nrcTeach/queryTeach";
	
	private final String SAVE_TEACH = "/nrcTeach/saveTeach";
	
	private final String VIEW_TEACH = "/nrcTeach/viewTeach";
	
	@Autowired
	private NrcTeachService nrcTeachService;
	
	/**
	 * 进入老师列表页面
	 * @return
	 */
	@RequestMapping("/queryTeachList")
	public ModelAndView queryTeachListInit(){
		return new ModelAndView(QUERY_TEACH);
	}
	
	/**
	 * 跳转到查看页面
	 * @return
	 */
	@RequestMapping("/viewTeach")
	public ModelAndView viewTeach(Long id,ModelMap map){
		NrcTeachDomain domain = nrcTeachService.queryNrcTeachById(id);
		if (domain != null) {
			map.put("teach", domain);
		}
		return new ModelAndView(VIEW_TEACH);
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("/saveTeach")
	public ModelAndView saveTeach(){
		return new ModelAndView(SAVE_TEACH);
	}

}
