package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.dao.UserDao;
import com.edu.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	public int addUser(User user){
		return userDao.addUser(user);
	}
}
