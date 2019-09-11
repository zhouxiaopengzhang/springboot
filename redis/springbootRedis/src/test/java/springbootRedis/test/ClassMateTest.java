package springbootRedis.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mymaven.ssmDemo.SsmDemoApplication;
import com.mymaven.ssmDemo.pojo.ClassMate;
import com.mymaven.ssmDemo.pojo.Student;
import com.mymaven.ssmDemo.repository.ClassMateRedis;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SsmDemoApplication.class})
public class ClassMateTest {
	@Autowired
	private ClassMateRedis cmr;
	/*向redis中添加复合对象（包含其他对象）*/
	//@Test
	public void addClassMate(){
		ClassMate cm=new ClassMate();
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"张三","男"));
		students.add(new Student(2,"李四","男"));
		cm.setId(1);
		cm.setStudents(students);
		//向redis中添加复合对象
		cmr.addClassMate(cm);
	}
	/*从redis中获取复合对象（包含其他对象）*/
	@Test
	public void getClassMate(){
		ClassMate cm=cmr.getClassMate(1);
		System.out.println(cm.getStudents());
	}
		
		
}
