package com.mymaven.maven_oper_stu_demo3.entity;

public class Student {
	private Integer id;
	private String name;
	private String classid;
	private Integer score;
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
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classid=" + classid + ", score=" + score + "]";
	}
	
}
