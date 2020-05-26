package com.dnt.cloud.student.web.filter;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc //不能加入这个注解否则不执行自定义的converter
public class OaWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Resource(name = "behaviorInterceptor")
	private OaInterceptor behaviorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(behaviorInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/user/userLogin","/welcome/**",
						"/userData/userLogin", "/user/logout", "/",
						 "/layuiadmin/**","/login","/images/**","/user/loginOut",
						 "/permission","/noPermission","/api/**");
		// 排除拦截目录 /extinterface/** 两个星“*”表示 该目录下及其子目录 全部涵盖
		//"/stores/*","/activity/*","/device/*","/pdAply/*","/simditor/*",
		//"/pdNotice/*","/pdqa/*","/brand/*","/category/*",
		super.addInterceptors(registry);
	}
}
