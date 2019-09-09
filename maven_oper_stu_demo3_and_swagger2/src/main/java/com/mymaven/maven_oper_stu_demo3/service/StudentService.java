package com.mymaven.maven_oper_stu_demo3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mymaven.maven_oper_stu_demo3.dao.StudentDAO;
import com.mymaven.maven_oper_stu_demo3.entity.Student;

/*
 * @service标记的类应该放在启动类（被@SpringBootApplication注解标记的类）的包下
 */
@Service
public class StudentService {
	@Autowired
	private StudentDAO dao; 
	/*
	 * 获取所有学生信息
	 */
	public List<Student> getStus(){
		return dao.getStus();
	}
	/*
	 * 根据id获取学生信息
	 */
	public Student getStu(int id){
		return dao.getStu(id);
	}
	/*
	 * 添加学生信息
	 */
	public void addStu(Student s){
		
		dao.addStu(s.getId(),s.getName(),s.getClassid(),s.getScore());
	}
	/*
	 * 更新根据id学生信息
	 */
	
		public void updateStu(Student s){
			dao.updateStu(s.getName(), s.getClassid(), s.getScore(), s.getId());
		}
	/*
	 * 根据id删除学生信息
	 */
	public void delStu(int id){
		dao.delStu(id);
	}
}
