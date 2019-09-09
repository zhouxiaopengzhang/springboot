package com.mymaven.maven_oper_stu_demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * 查看在线生成文档的网址如下：
 * http://localhost:8087/swagger-ui.html
 * 这其中端口号为spring boot内置的Tomcat服务器的端口号，默认为8080；可以在.properties配置文件中重新设置端口号
 */

/*@swagger是用于定义API文档的，这个注解是在原来的spring boot 实现restful形式对数据库执行curd操作功能基础之上添加的额外功能
 * 启动swagger注解使得在controller中的swagger注解生效，覆盖的范围由@ComponentScan的配置来决定，这里默认指定为
 * 根路径“com.mymaven.maven_oper_stu_demo3”下的所有controller
 * */
@EnableSwagger2		//启动swagger注解
//开启spring对注解AOP的支持
@EnableAspectJAutoProxy 	
@ComponentScan(basePackages={"aop"
		,"config"
		,"com.mymaven.maven_oper_stu_demo3.controller"
		,"com.mymaven.maven_oper_stu_demo3.controller2"
		,"com.mymaven.maven_oper_stu_demo3.dao"
		,"com.mymaven.maven_oper_stu_demo3.service"})
@SpringBootApplication	//等同于@Configuration+@EnableAutoConfiguration+@ComponentScan
public class MavenOperStuDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(MavenOperStuDemo3Application.class, args);
	}

}
