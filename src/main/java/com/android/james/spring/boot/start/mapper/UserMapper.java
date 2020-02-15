package com.android.james.spring.boot.start.mapper;

import com.android.james.spring.boot.start.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {
	
	List<User> getUsers();
	
}
