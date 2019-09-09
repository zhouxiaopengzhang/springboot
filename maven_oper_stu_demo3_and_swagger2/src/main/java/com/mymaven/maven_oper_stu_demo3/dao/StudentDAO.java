package com.mymaven.maven_oper_stu_demo3.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/*
 * 注意：getStu()方法的注解的SQL语句中只有一个参数#{id}，因此getStu(Integer id)方法的形参id前不需要加注解@param;
 * 而addStu()方法的注解的SQL语句中有4个参数#{id}、#{name}、#{classid}、#{score}，那么addStu中也必须有4个参数用来给
 * SQL语句传参，那么SQL语句中的参数#{id}如何知道我需要方法中的4个参数中的哪一个呢，因此必须为方法中的参数做唯一标识
 */

import com.mymaven.maven_oper_stu_demo3.entity.Student;
@Mapper	//该注解是mybatis的注解
public interface StudentDAO {
	/*
	 * 添加学生:注解的参数与方法的参数必须一致，不能在addStu()方法中使用Student类型的参数
	 * 插入语句是没有返回值的
	 */
	@Insert("insert into score (id,name,classid,score) values(#{id},#{name},#{classid},#{score})")
	public void addStu(@Param("id") Integer id,@Param("name") String name,@Param("classid") String classid,@Param("score") Integer score); 
	/*
	 * 获取所有学生
	 */
	@Select("select * from score")
	public List<Student> getStus();
	/*
	 * 获取单个学生信息
	 */
	@Select("select * from score where id=#{id}")
	public Student getStu(Integer id);
	/*
	 * 删除学生信息
	 */
	@Delete("delete from score where id=#{id}")
	public void delStu(Integer id);
	/*
	 * 更新学生信息
	 */
	@Update("update score set name=#{name},classid=#{classid},score=#{score} where id=#{id}")
	public void updateStu(@Param(value = "name") String name,@Param(value = "classid") String classid,@Param(value = "score") Integer score,@Param(value = "id") Integer id);
}
