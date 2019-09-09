package aop;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 注解配置AOP步骤
 * 第一步：定义通知类，并将该类交给容器管理
 * 第二步：配置切面，即在通知类上添加切面注解
 * 第三步：定义切入点表达式
 * 第四步：定义通知方法
 * 最后一步（重要）：在程序主入口添加扫描注解@ComponentScan，将该类所在的包添加到扫描注解中
 */
@Component("logAspect")		//把该类交给IOC容器处理
@Aspect()			//配置切面

public class LogAspect {
	/*
	 *切入点表达式
	 */
	@Pointcut(value="execution(* com.mymaven.maven_oper_stu_demo3.dao.StudentDAO.*(..))")
	public void asp(){}
		
	@Autowired
	HttpServletRequest request;
	/*
	 * 前置通知
	 */
	@Before(value = "asp()")
	public void printBefore(JoinPoint joinPoint){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d=format.format(date);
		String method=request.getMethod();
		System.out.println("请求方法："+method);
		Enumeration<String> enumeration=request.getHeaderNames();
		/*
		 * 当前循环的内容是请求头的内容
		 */
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement()+":"+request.getHeader(enumeration.nextElement()));
			
		}
		/*
		 * 输出的内容是
		 */
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		System.out.println(request.getRemoteAddr());
		
		System.out.println("前置通知"+d);
	}
	/*
	 * 后置通知
	 */
	@After(value = "asp()")
	public void printAfter(JoinPoint joinPoint){
		System.out.println("后置通知");
	}
}
