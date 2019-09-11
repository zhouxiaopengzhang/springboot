package com.mymaven.ssmDemo.repository;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.mymaven.ssmDemo.pojo.ClassMate;
/*在redis中对复杂对象进行添加和查询*/
@Repository
public class ClassMateRedis {
	@Autowired
	private RedisTemplate redisTemplate;
	@Resource(name="redisTemplate")
	private ValueOperations<Object,Object> valops;
	/*对redis数据库进行增加与查询操作*/
	public void addClassMate(ClassMate cm){
		//将cm对象的id值作为key，cm对象作为value
		valops.set(cm.getId(), cm);
	}
	public ClassMate getClassMate(Object key){
		//将cm对象的id值作为key，cm对象作为value
		return (ClassMate) valops.get(key);
	}
}
