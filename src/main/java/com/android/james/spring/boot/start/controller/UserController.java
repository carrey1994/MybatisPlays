package com.android.james.spring.boot.start.controller;

import com.android.james.spring.boot.start.User;
import com.android.james.spring.boot.start.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/")
	public String sayHello() {
		return "<H1>HelloWorld</H1>";
	}
	
	
	@RequestMapping("/findUsers")
	public List<User> findUsers() {
		return userMapper.getUsers();
	}
}
