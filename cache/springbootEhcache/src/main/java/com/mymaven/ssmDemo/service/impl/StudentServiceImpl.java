package com.mymaven.ssmDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mymaven.ssmDemo.pojo.Student;
import com.mymaven.ssmDemo.repository.StudentRepository;
import com.mymaven.ssmDemo.service.StudentService;
/*spring的缓存策略是以键值对存储存储数据，key为方法参数，value为方法返回值*/
//给该类配置指定的缓存策略
@CacheConfig(cacheNames={"sampleCache1"})
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repository;
	@Cacheable	//存储缓存，主要用在查找方法上
	@Override
	public List<Student> findStudentAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Cacheable	//存储缓存，主要用在查找方法上
	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}
	@Cacheable
	@Override
	public Page<Student> findStudentByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}
	@CachePut	//主要用于修改方法上
	@Override
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(s);
	}

}
