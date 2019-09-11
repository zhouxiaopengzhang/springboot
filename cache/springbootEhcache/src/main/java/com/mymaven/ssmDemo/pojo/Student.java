package com.mymaven.ssmDemo.pojo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*创建学生实体类*/
@Table(name="student")
@Entity
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//只要主键id使用了@GeneratedValue注解，那么表示主键自动生成
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	@Column(name="Name")
	private String name;
	private String sex;
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
