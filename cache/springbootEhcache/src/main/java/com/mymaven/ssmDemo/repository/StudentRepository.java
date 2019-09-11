package com.mymaven.ssmDemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mymaven.ssmDemo.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
