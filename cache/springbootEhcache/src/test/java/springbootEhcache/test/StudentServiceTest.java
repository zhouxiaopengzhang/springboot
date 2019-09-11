package springbootEhcache.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mymaven.ssmDemo.SsmDemoApplication;
import com.mymaven.ssmDemo.pojo.Student;
import com.mymaven.ssmDemo.service.impl.StudentServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SsmDemoApplication.class)
public class StudentServiceTest {
	@Autowired
	private StudentServiceImpl serviceImpl;
	@Test
	public void getStudentById(){
		/*在配置ehcache缓存之前，将查询一条记录2次，那么就会访问两次数据库*/
		//Student s=serviceImpl.findStudentById(1);
		//Student s2=serviceImpl.findStudentById(1);
		//System.out.println("s:"+s);
		//System.out.println("s2:"+s2);
		/*在配置ehcache缓存之后，将查询一条记录2次，只会访问1次数据库*/
		Student s=serviceImpl.findStudentById(1);
		Student s2=serviceImpl.findStudentById(1);
		System.out.println("s:"+s);
		System.out.println("s2:"+s2);
		//根据控制台打印的结果表明配置ehcache缓存成功了
	}
	//@Test
	public void getStudentAll(){
		List<Student> ls=serviceImpl.findStudentAll();
		System.out.println(ls);
	}
	//@Test
	public void getStudenByPage(){
		//serviceImpl.findStudentByPage(pageable);
	}
	//@Test
	public void saveStudent(){
		Student s=new Student();
		s.setName("zhangsan");
		s.setSex("男");
	}
}
