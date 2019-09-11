package com.mymaven.ssmDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*持久层是基于hibernate访问数据库的*/
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mymaven.ssmDemo.filter.CustomFilter;
@SpringBootApplication
public class SsmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmDemoApplication.class, args);
	}
	/*注册过滤器*/
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean filter=new FilterRegistrationBean(new CustomFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}
}
