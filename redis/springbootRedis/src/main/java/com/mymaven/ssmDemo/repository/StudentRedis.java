package com.mymaven.ssmDemo.repository;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import com.mymaven.ssmDemo.pojo.Student;
/*该类可以访问Redis*/
@Repository
public class StudentRedis {
	/*
	 springboot已为我们配置了StringRedisTemplate以及RedisTemplate，在此处可以直接注入。	
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	/*将stringRedisTemplate注入到ValueOperations中*/
	@Resource(name="stringRedisTemplate")
	private ValueOperations<String,String> valOpsStr;	//对Redis数据库进行操作，泛型为键值对的类型
	
	@Autowired
	private RedisTemplate redisTemplate;
	/*将stringRedisTemplate注入到ValueOperations中*/
	@Resource(name="redisTemplate")
	private ValueOperations<Object,Object> valOps;	//对Redis数据库进行操作，泛型为键值对的类型
	//向Redis数据库添加字符串
	public void stringRedisTemplateDemo(){
		valOpsStr.set("myStringKey", "myStringValue");
	}
	//向Redis数据库添加对象Student
	public void saveStudent(Student s){
		valOps.set(s.getId(),s);
	}
	//从Redis数据库获取对象Student
	public Student getStudent(Integer id){
		Student s=(Student)valOps.get(id);
		return s;
	}
	//从Redis数据库获取字符串
		public String getString(){
			String s=valOpsStr.get("myStringKey");
			return s;
		}
}
