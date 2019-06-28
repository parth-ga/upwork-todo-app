package com.todo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterLogin() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new CORSFilter());
		bean.addUrlPatterns("/", "/*");
		return bean;
	}
}