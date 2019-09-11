package com.mymaven.ssmDemo.pojo;
import java.io.Serializable;

/*创建学生实体类*/
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String sex;
	public Student() {
	}
	public Student(Integer id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
}
