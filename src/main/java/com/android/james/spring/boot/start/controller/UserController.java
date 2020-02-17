package com.android.james.spring.boot.start.controller;

import com.android.james.spring.boot.start.RedisConfig;
import com.android.james.spring.boot.start.User;
import com.android.james.spring.boot.start.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisConfig redisConfig;
	
	@Autowired
	RedisTemplate redisTemplate;
	//使用序列化的key存在DB
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	//使用不經序列化的key存在DB
	
	@RequestMapping("/")
	public String sayHello() {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set("first_name", "james");
		return "<H1>" + valueOperations.get("first_name") + "</H1>";
	}
	
	@RequestMapping("/findUsers")
	public List<User> findUsers() {
		return userMapper.getUsers();
	}
	
	@PostMapping("/addUser")
	@Transactional(rollbackFor = SQLException.class)
	public int addUser(@RequestBody User newUser) {
		return userMapper.addUser(null);
	}
	
	@PostMapping("/deleteUser")
	public long deleteUser(@RequestBody HashMap<String, Integer> map) {
		return userMapper.deleteUser(map.get("id"));
	}
	
	@PostMapping("/updateUser")
	public long updateUser(@RequestBody User updatedUser) {
		return userMapper.updateUser(updatedUser);
	}
	
	@PostMapping("/addQuiz")
	public void addQuiz(@RequestBody User user) {
		stringRedisTemplate.opsForHash().put("RedisUsers", String.valueOf(user.getId()), new Gson().toJson(user));
	}
	
	
}
