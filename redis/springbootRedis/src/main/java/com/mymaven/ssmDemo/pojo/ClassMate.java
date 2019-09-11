package com.mymaven.ssmDemo.pojo;

import java.io.Serializable;
import java.util.List;

/*
 定义班级:包含班级id与学生集合
 */
public class ClassMate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private List<Student> students;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
