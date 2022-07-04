package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.edu.domain.User;

@Mapper
public interface UserDao {
	List<User> findAll();
	
	User findByLoginId(String loginId);
	
	User findByNmae(String name);
	
	int addUser(User user);
	
	
}
