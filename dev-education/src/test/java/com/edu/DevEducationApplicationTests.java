package com.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.edu.dao.UserDao;
import com.edu.domain.User;

@SpringBootTest
class DevEducationApplicationTests {

	@Autowired
	UserDao userDao;
	@Test
	void contextLoads() {
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setLoginId("sgwei71");
		user.setName("위성규");
		user.setZipNo("111-111");
		user.setAddress("서울 을지로");;
		
		 int ret=userDao.addUser(user);
		 
		 assertEquals(ret,1);
		
	}
	
	@Test
	public void findByName() {
		User user = new User();
		user.setName("위성규");
		
		
		
	}

	@Test
	public void findByLoginId() {
		
		
	}
	
	@Test
	public void findAll() {
		
		
	}
}
