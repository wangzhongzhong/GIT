/**
 * 
 */
package com.dnt.cloud.student.web.action;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.student.domain.NrcClassMateDomain;
import com.dnt.cloud.student.domain.NrcTeachDomain;
import com.dnt.cloud.student.enums.NrcTeachTypeEnum;
import com.dnt.cloud.student.query.NrcTeachQuery;
import com.dnt.cloud.student.service.NrcClassMateService;
import com.dnt.cloud.student.service.NrcTeachService;

/**
 * @author julio
 *
 */
@RequestMapping("/classMate")
@Controller
public class NrcClassMateAction {
	
	private final String QUERY_CLASS = "/nrcClassMate/queryClassMate";
	
	private final String SAVE_CLASS = "/nrcClassMate/saveClassMate";
	
	private final String VIEW_CLASS = "/nrcClassMate/viewClassMate";
	
	@Autowired
	private NrcClassMateService nrcClassMateService;
	
	@Autowired
	private NrcTeachService nrcTeachService;
	
	/**
	 * 查询列表页
	 * @return
	 */
	@RequestMapping("/queryNrcClassMateList")
	public ModelAndView queryNrcClassMateListInit(ModelMap map){
		this.dealWithTeachList(map);
		return new ModelAndView(QUERY_CLASS);
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("/saveNrcClassMate")
	public ModelAndView saveNrcClassMate(ModelMap map){
		this.dealWithTeachList(map);
		return new ModelAndView(SAVE_CLASS);
	}
	
	/**
	 * 跳转到查看页面
	 * @return
	 */
	@RequestMapping("/viewNrcClassMate")
	public ModelAndView viewNrcClassMate(ModelMap map,Long id){
		this.dealWithTeachList(map);
		NrcClassMateDomain domain = nrcClassMateService.queryNrcClassMateById(id);
		if (domain != null) {
			map.put("result", domain);
		}
		return new ModelAndView(VIEW_CLASS);
	}
	
	/**
	 * 把班主任列表放在map中
	 * @param map
	 */
	public void dealWithTeachList(ModelMap map){
		NrcTeachQuery query = new NrcTeachQuery();
		query.setType(NrcTeachTypeEnum.B.getCode());
		PageData<NrcTeachDomain> nrcTeachPage = nrcTeachService.queryNrcTeachDomain(query);
		if (nrcTeachPage != null) {
			List<NrcTeachDomain> list = nrcTeachPage.getList();
			if (!CollectionUtils.isEmpty(list)) {
				map.put("teachList", list);
			}
		}
	}

}
