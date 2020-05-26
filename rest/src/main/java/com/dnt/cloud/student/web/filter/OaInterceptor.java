package com.dnt.cloud.student.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component("behaviorInterceptor")
public class OaInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired
//	private NrcResouceService nrcResourceService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		// 1. 第一步,先判断是否登录
//		NrcUserDomain userDomain = getCurrentUser(request, response);
//		// 2. 判断是否已经登录
//		if (userDomain != null) {
//			logger.info("{}当前请求的用户:{}",LogPrefixFactory.getLogPrefix(), userDomain.getRealName());
//			String url = request.getRequestURI();
//			if (StringUtils.equals("/cloud-dnt-oa/error", url)) {
//				return true;
//			}
//			boolean permissionFlag = getPermission(request, userDomain, url);
//			// 4. 最后返回是否能够通过
//			if (permissionFlag) {
//				// 5. 如果为true,直接放行
//				return true;
//			} else {
//				response.sendRedirect(request.getContextPath() + "/permission");
//				// 6. 否则的话,就跳转到统一的页面
//				if (request.getHeader("x-requested-with") != null
//						&& request.getHeader("x-requested-with")
//								.equalsIgnoreCase("XMLHttpRequest")) {
//					// 如果是ajax请求响应头会有，x-requested-with；
//					response.setHeader("sessionstatus", "noAuthority");
//					// 在响应头设置session状态
//					response.setStatus(302);
//					return false;
//				}
//				return false;
//			}
//		}else{
//			response.sendRedirect(request.getContextPath() + "/user/userLogin");
//			logger.info("{}用户还未登录。。。。",LogPrefixFactory.getLogPrefix());
//			return true;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}
	
//	protected NrcUserDomain getCurrentUser(HttpServletRequest request,
//			HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		NrcUserDomain user = (NrcUserDomain) session
//				.getAttribute("user");
//		if (user == null) {
//			logger.info("{}Session Error,Foward Login Page!",LogPrefixFactory.getLogPrefix());
//			try {
//				response.sendRedirect(request.getContextPath() + "/user/userLogin");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			request.getSession().setAttribute("realName", user.getRealName());
//		}
//		return user;
//	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
	
	/**
	 * 判断用户是否有访问URL的权限
	 * 
	 * @param request
	 * @param userDomain
	 * @return
	 */
//	private boolean getPermission(HttpServletRequest request,
//			NrcUserDomain userDomain, String url) {
//		// 1. 获取用户的userId
//		Long userId = userDomain.getId();
//		logger.info("{}当前请求的URL:{}",LogPrefixFactory.getLogPrefix(), url);
//		boolean permissionFlag = nrcResourceService.selectResourceByUserIdFlag(userId,url);
//		return permissionFlag;
//	}
}
