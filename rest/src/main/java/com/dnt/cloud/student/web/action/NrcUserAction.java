/**
 * 
 */
package com.dnt.cloud.student.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dnt.cloud.student.domain.NrcRoleDomain;
import com.dnt.cloud.student.domain.NrcUserDomain;
import com.dnt.cloud.student.service.NrcUserService;

/**
 * @author julio
 *
 */
@RequestMapping("/user")
@Controller
public class NrcUserAction{
	
	@Autowired
	private NrcUserService nrcUserService;
	
	private static final String USER_LIST = "/nrcUser/queryUserList";
	
	private static final String VIEW_USER = "/nrcUser/viewUser";
	
	private static final String VIEW_SELF_USER = "/nrcUser/viewSelfUser";
	
	private static final String SAVE_USER = "/nrcUser/saveUser";
	
	private static final String VIEW_SELF_SIGN = "/nrcUser/updateSelfSign";
	
	/**
	 * 用户登录页面
	 * @return
	 */
	@RequestMapping("/userLogin")
	public ModelAndView index(){
		return new ModelAndView("/login");
	}
	
	/**
	 * 用户登出页面
	 * @return
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request, ModelAndView mv){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("realName");
		session.removeAttribute("user");
		return new ModelAndView("/login");
	}
	
	/**
	 * 进入用户列表页面
	 * @return
	 */
	@RequestMapping("/queryUserList")
	public ModelAndView queryUserListInit(){
		return new ModelAndView(USER_LIST);
	}

	/**
	 * 查询用户的详情
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/viewUserDetail")
	public ModelAndView viewUserDetail(Long userId,ModelMap map){
		NrcUserDomain nrcUserDomain = nrcUserService.selectNrcUserDomainbyId(userId);
		map.put("user", nrcUserDomain);
//		//1. 查询该用户已经有的角色
//		List<NrcRoleDomain> nrcRoleDomainlist = nrcRoleService.selectNrcRoleByUserId(userId);
//		Map<Long, NrcRoleDomain> nrcRoleDomainMap = new HashMap<Long, NrcRoleDomain>();
//		if (CollectionUtils.isNotEmpty(nrcRoleDomainlist)) {
//			nrcRoleDomainlist.forEach(data -> {
//				nrcRoleDomainMap.put(data.getId(), data);
//			});
//		}
//		//2. 查询所有的角色
//		List<NrcRoleDomain> allRoleDomainList = nrcRoleService.selectAllNrcRole();
//		allRoleDomainList.forEach(data ->{
//			if (nrcRoleDomainMap.get(data.getId()) != null) {
//				data.setChecked("Y");
//			}
//		});
//		map.put("roleList", allRoleDomainList);
		return new ModelAndView(VIEW_USER);
	}
	
	/**
	 * 查询用户的详情
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/viewSelfUserDetail")
	public ModelAndView viewSelfUserDetail(Long userId,ModelMap map){
		NrcUserDomain nrcUserDomain = nrcUserService.selectNrcUserDomainbyId(userId);
		map.put("user", nrcUserDomain);
		return new ModelAndView(VIEW_SELF_USER);
	}
	
	/**
	 * 添加用户信息
	 * @return
	 */
	@RequestMapping("/saveUserDomain")
	public ModelAndView saveUserDomain(ModelMap map){
//		//1. 获取所有角色
//		List<NrcRoleDomain> nrcRoleDomainList = nrcRoleService.selectAllNrcRole();
//		if (!CollectionUtils.isEmpty(nrcRoleDomainList)) {
//			map.put("roleList", nrcRoleDomainList);
//		}
		return new ModelAndView(SAVE_USER);
	}
	
}
