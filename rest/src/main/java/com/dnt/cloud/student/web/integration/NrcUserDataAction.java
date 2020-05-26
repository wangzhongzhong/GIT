package com.dnt.cloud.student.web.integration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dnt.cloud.common.domain.result.PageData;
import com.dnt.cloud.common.lang.StringUtil;
import com.dnt.cloud.student.domain.NrcUserDomain;
import com.dnt.cloud.student.query.NrcUserQuery;
import com.dnt.cloud.student.service.NrcUserService;
import com.dnt.cloud.student.web.domain.NrcDataDomain;
import com.dnt.cloud.student.web.util.EncryptUtil;
import com.dnt.cloud.student.web.util.EscapeDomainUtils;
import com.dnt.cloud.web.common.BaseController;

/**
 * 用户数据接口
 * @author decade
 *
 */
@RequestMapping("/userData")
@RestController
public class NrcUserDataAction extends BaseController  {
	
	private Logger logger = LoggerFactory.getLogger(NrcUserDataAction.class);
	
	@Autowired
	private NrcUserService nrcUserService;
	
	@Value("${content.ftp.host:106.14.220.4}")
	private String host;
	
	@Value("${content.ftp.port:21}")
	private int port;
	
	@Value("${content.ftp.userName:ftpuser}")
	private String userName;
	
	@Value("${content.ftp.password:dnt@ftp}")
	private String password;
	
	@Value("${content.ftp.root:content/OA/}")
	private String root;
	
	@Value("${content.ftp.DNS:http://www.scanall-nrc.cn}")
	private String DNS;
	
	/**
	 * 登录接口
	 * @param loginName
	 * @param pwd
	 * @param request
	 * @param mv
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/userLogin")
	public String login(String loginName,String pwd,HttpServletRequest request, ModelAndView mv, ModelMap map){
		//layui数据模板
		NrcDataDomain nrcDataDomain = new NrcDataDomain();
		nrcDataDomain.setCode(0);
		if (StringUtil.isBlank(loginName) || StringUtil.isBlank(pwd)) {
			nrcDataDomain.setMsg("账号密码不能为空");
			return JSON.toJSONString(nrcDataDomain);
		}
		HttpSession session = request.getSession();
		// 加密
		String encryptData = EncryptUtil.enCrypt(pwd);
		NrcUserDomain user = nrcUserService.login(
				loginName, encryptData);
		if(user!=null){
			session.setAttribute("user", user);
			session.setAttribute("name", user.getName());
			nrcDataDomain.setMsg("true");
			return JSON.toJSONString(nrcDataDomain);
		}else{
			nrcDataDomain.setMsg("登录名或密码错误");
			return JSON.toJSONString(nrcDataDomain);
		}
	}
	
	/**
	 * 查询用户列表
	 * @param query
	 * @return
	 */
	@RequestMapping("/getUserList")
	public NrcDataDomain getUserList(@RequestParam("page") int page,
			@RequestParam("limit")int limit,NrcUserQuery query){
		NrcDataDomain nrcDataDomain = new NrcDataDomain();
		nrcDataDomain.setCode(0);
		query.setPageNum(page);
		query.setPageSize(limit);
		PageData<NrcUserDomain> pageResult = nrcUserService.selectNrcUserDomain(query);
		if (pageResult == null) {
			nrcDataDomain.setMsg("查询对应条件用户数据不存在");
		}else{
			List<NrcUserDomain> list = pageResult.getList();
			nrcDataDomain.setData(list);
			nrcDataDomain.setCount(pageResult.getTotal());
			nrcDataDomain.setMsg("查询用户列表成功");
		}
		return nrcDataDomain;
	}
	
	/**
	 * 更新用户信息
	 * @param nrcUserDomain
	 * @return
	 */
	@RequestMapping("/updateNrcUser")
	public NrcDataDomain updateNrcUser(
			@RequestParam(name = "roleList", required = false) String roleList,
			NrcUserDomain nrcUserDomain){
		//转译
		nrcUserDomain = (NrcUserDomain) EscapeDomainUtils.escapeDomaindata(nrcUserDomain);
		roleList = EscapeDomainUtils.escape(roleList);
		NrcDataDomain nrcDataDomain = new NrcDataDomain();
		nrcDataDomain.setCode(0);
		boolean updateDataDomain = false;
		try {
			updateDataDomain = nrcUserService.update(nrcUserDomain);
			if (updateDataDomain) {
				nrcDataDomain.setMsg("true");
			}else{
				nrcDataDomain.setMsg("更新失败");
			}
		} catch (Exception e) {
			nrcDataDomain.setMsg(e.getMessage());
		}
		return nrcDataDomain;
	}
	
	/**
	 * 新增用户信息
	 * @param nrcUserDomain
	 * @return
	 */
	@RequestMapping("/saveNrcUser")
	public NrcDataDomain saveNrcUser(
			@RequestParam(name = "roleList", required = false) String roleList,
			NrcUserDomain nrcUserDomain){
		//转译
		nrcUserDomain = (NrcUserDomain) EscapeDomainUtils.escapeDomaindata(nrcUserDomain);
		roleList = EscapeDomainUtils.escape(roleList);
		NrcDataDomain nrcDataDomain = new NrcDataDomain();
		nrcDataDomain.setCode(0);
		boolean updateDataDomain = false;
		nrcUserDomain.setPassword(EncryptUtil.enCrypt(nrcUserDomain.getPassword()));
		try {
			updateDataDomain = nrcUserService.save(nrcUserDomain);
			if (updateDataDomain) {
				nrcDataDomain.setMsg("true");
			}else{
				nrcDataDomain.setMsg("新增失败");
			}
		} catch (Exception e) {
			nrcDataDomain.setMsg(e.getMessage());
		}
		return nrcDataDomain;
	}
	
	/**
	 * 重置用户密码
	 * @param userId
	 * @return
	 */
	@RequestMapping("/resetUserPwd")
	public NrcDataDomain resetUserPwd(NrcUserDomain nrcUserDomain){
		//转译
		nrcUserDomain = (NrcUserDomain) EscapeDomainUtils.escapeDomaindata(nrcUserDomain);
		NrcDataDomain nrcDataDomain = new NrcDataDomain();
		nrcDataDomain.setCode(0);
		// 加密
		String encryptData = EncryptUtil.enCrypt("123456");
		nrcUserDomain.setPassword(encryptData);
		boolean result = false;
		result = nrcUserService.resetUserPwd(nrcUserDomain.getId(), encryptData);
		if (result) {
			nrcDataDomain.setMsg("true");
		}else{
			nrcDataDomain.setMsg("重置密码失败");
		}
		return nrcDataDomain;
	}
	
	/**
	 * 基线3.0
	 * 密码确认
	 * @param originalPwd
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String confirmPwd(@RequestParam("originalPwd") String originalPwd,
			@RequestParam("userId") Long userId) {
		// 加密
		String encryptData = EncryptUtil.enCrypt(originalPwd);
		NrcUserDomain nrcUserDomain = nrcUserService.selectNrcUserDomainbyId(userId);
		if (nrcUserDomain != null) {
			if (nrcUserDomain.getPassword().equals(encryptData)) {
				return "true";
			} else {
				return "false";
			}
		} else {
			return "false";
		}
	}
	
	/**
	 * 基线3.0修改密码-用户管理修改页面专用
	 * @param request
	 * @param oldPwd
	 * @param newPwd
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest request,
			@RequestParam(value="originalPwd",required=false) String oldPwd,
			@RequestParam(value="newPwd",required=false) String newPwd,
			@RequestParam(value="userId",required=false) Long userId) {
		// 加密
		String oldEncryptData = EncryptUtil.enCrypt(oldPwd);
		String encryptData = EncryptUtil.enCrypt(newPwd);
		NrcUserDomain nrcUserDomain = nrcUserService.selectNrcUserDomainbyId(userId);
		if(nrcUserDomain!=null){
			if(!nrcUserDomain.getPassword().equals(oldEncryptData)){
				return "原始密码不正确";
			}else{
				NrcUserDomain user = nrcUserDomain;
				user.setPassword(encryptData);
				boolean update;
				try {
					update = nrcUserService.update(user);
					if(update){
						return "true";
					}else{
						return "false";
					}
				} catch (Exception e) {
					return e.getMessage();
				}
			}
		}else{
		    return "false";
		}
	}
}
