package springbootRedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mymaven.ssmDemo.SsmDemoApplication;
import com.mymaven.ssmDemo.pojo.Student;
import com.mymaven.ssmDemo.repository.StudentRedis;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SsmDemoApplication.class)
public class StudentServiceTest {
	@Autowired
	private StudentRedis studentRedis;
	//@Test
	public void setString(){
		studentRedis.stringRedisTemplateDemo(); //该方法保存一个键值对
	}
	//@Test
	public void getString(){
		String s=studentRedis.getString();	//该方法保存一个键值对
		System.out.println(s);
	}
	//@Test
	public void setStudent(){
		Student s=new Student();
		s.setId(1);
		s.setName("zhangsan");
		s.setSex("male");
		//向redis数据库中添加对象
		studentRedis.saveStudent(s);
	}
	@Test
	public void getStudent(){
		//从redis数据库中获取对象
		Student s=studentRedis.getStudent(1);
		System.out.println(s);
	}
}
