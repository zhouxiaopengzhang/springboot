package com.mymaven.ssmDemo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mymaven.ssmDemo.pojo.Student;

public interface StudentService {
	public List<Student> findStudentAll();
	public Student findStudentById(Integer id);
	public Page<Student> findStudentByPage(Pageable pageable);
	public void saveStudent(Student s);
}
