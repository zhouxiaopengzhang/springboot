package com.mymaven.maven_oper_stu_demo3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymaven.maven_oper_stu_demo3.entity.Student;
import com.mymaven.maven_oper_stu_demo3.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
//@Api是swagger扩展功能
@Api("student_operation数据库操作API")
/*该类只是对外提供接口，具体实现需要在service层实现*/
@RestController
@RequestMapping("/api")
public class MyController {
	//此处需要一个服务层的实现类，在MyController类中的各个方法中实现具体的操作
	@Autowired
	StudentService service;
	
	
	/*以下3个@Api开头的注解用于生成add方法的api说明文档
	 * 1.每个方法都是一个操作，因此需要使用注解@ApiOperation标记方法
	 * 2.如果方法有1个参数，那么就需要使用@ApiImplicitParam来对参数进行描述，比如参数名，数据类型，参数类型等等；
	 * 	如果方法有多个参数，那么就需要使用@ApiImplicitParams来将多个参数注解@ApiImplicitParam包含到一起
	 * 3.方法有返回值，那么就需要使用@ApiResponses注解,因为响应有好几种比如403,404,200等等，因此可以在@ApiResponses里
	 * 	面使用@ApiResponse注解分别描述不同的响应。(其实这个步骤3是可选的，因为这个注解只是为了改变message的值；如
	 * 	果不加code=404的注解@ApiResponse,那么message的默认值就是“Not Found”)
	 */
	@ApiOperation("添加学生信息")	//说明方法的功能
	@ApiImplicitParam(paramType="body",name="s",dataType="Student",required=true)
	@ApiResponses({
		@ApiResponse(code = 400, message = "请求参数没填好"),
		@ApiResponse(code = 404, message ="请求路径地址错误")
	})
		//添加学生
	@RequestMapping(path="/student",method=RequestMethod.POST,produces="application/json")
	public Student add(@RequestBody Student s){
		System.out.println(s.toString());
		service.addStu(s);
		return s;
	}
	
	
	/*以下2个@Api开头的注解用于生成delete方法的说明文档
	 * 关于注解各个参数的值可以查看注解源码
	 */
	@ApiOperation(value="删除学生信息")
	@ApiImplicitParam(paramType="path",name="id",dataType="int",required=true)
	//删除学生
	/*http的delete请求没有返回值*/
	@RequestMapping(path="/student/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		service.delStu(id);
	}
	
	
	/*以下3个@Api开头的注解用于生成query方法的说明文档
	 * 关于注解各个参数的值可以查看注解源码
	 * 没有在@ApiResponses中没有添加code为200的注解的原因：是因为如果查询成功会返回Student，即使添加返回成功的注解，这个注解
	 * 的message的值还是不会在响应体中出现，因为message的值被Student覆盖了
	 */
	@ApiOperation(value="查询学生信息")
	@ApiImplicitParam(paramType="path",name="id",dataType="int",required=true)
	@ApiResponses({
		@ApiResponse(code=404,message="url地址错误"),
		@ApiResponse(code=403,message="您被禁止访问该网页"),
		//@ApiResponse(code=200,message="查询成功")
	})
	//查询学生
	@RequestMapping(path="/student/{id}",method=RequestMethod.GET,produces="application/json")
	public Student query(@PathVariable int id){
		return service.getStu(id);
	}
	
	
	/*以下1个@Api开头的注解用于生成delete方法的说明文档
	 * 关于注解各个参数的值可以查看注解源码
	 */
	@ApiOperation(value="查询所有学生信息")
	//查询所有学生
	@RequestMapping(path="/students",method=RequestMethod.GET)
	public List<Student> queryAll(){
		 return service.getStus();
	}
	
	/*以下2个@Api开头的注解用于生成delete方法的说明文档
	 * 关于注解各个参数的值可以查看注解源码
	 */
	@ApiOperation(value="修改学生信息")
	@ApiImplicitParam(paramType="body",name="s",dataType="Student",required=true)
	//修改学生信息
	@RequestMapping(path="/student",method=RequestMethod.PUT,produces="application/json")
	public Student update(@RequestBody Student s){
		service.updateStu(s);
		return s;
	}
}
