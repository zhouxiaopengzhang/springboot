package com.mymaven.ssmDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/*持久层是基于hibernate访问数据库的*/
@SpringBootApplication
@EnableCaching	//启动ehcache
public class SsmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmDemoApplication.class, args);
	}

}
