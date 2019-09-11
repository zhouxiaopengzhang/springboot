package com.mymaven.ssmDemo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("springboot")
@RestController
public class MyController {
	@RequestMapping("/welcome")
	public String welcome(String name){
		return "hello "+name+" welcome to springboot.";
	}
}
