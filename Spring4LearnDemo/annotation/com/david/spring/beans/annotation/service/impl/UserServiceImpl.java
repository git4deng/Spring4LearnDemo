package com.david.spring.beans.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.beans.annotation.dao.UserDao;
import com.david.spring.beans.annotation.service.UserService;

/**
 * @描述：
 * @className:UserServiceImpl.java
 * @作者： David
 * @日期 2019-02-16 23:14:51
 */
@Service(value="userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;
	
	public void add() {
		System.out.println("模拟业务层。。。。");
		userdao.save();
		
	}

}
