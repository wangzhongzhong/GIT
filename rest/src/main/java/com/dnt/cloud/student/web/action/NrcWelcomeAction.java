package com.dnt.cloud.student.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台首页跳转
 * @author decade
 *
 */
@Controller
public class NrcWelcomeAction{
	
	private final String INDEX = "/index";
	
	private final String HOME = "/home/home";
	
	/**
	 * 首页
	 * @param mp
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/welcome")
	public ModelAndView index(
			ModelMap mp, HttpServletRequest request,HttpSession session) {
		return new ModelAndView(INDEX);
	}
	
	/**
	 * 无权限页面
	 * @return
	 */
	@RequestMapping(value = "/permission")
	public ModelAndView permission(){
		return new ModelAndView("/permission");
	}
	
	@RequestMapping(value = "/noPermission")
	public ModelAndView noPermission(){
		return new ModelAndView("/noPermission");
	}

}
