package com.mymaven.ssmDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SsmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmDemoApplication.class, args);
	}
}
