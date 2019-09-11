package com.mymaven.ssmDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@PropertySource( value = { "application.class" })
@SpringBootTest
public class SsmDemoApplicationTests {
	
	@Test
	public void contextLoads() {
	
	}

}
