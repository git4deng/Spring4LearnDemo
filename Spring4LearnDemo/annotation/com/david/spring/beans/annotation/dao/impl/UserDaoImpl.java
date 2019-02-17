package com.david.spring.beans.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.david.spring.beans.annotation.dao.UserDao;

/**
 * @描述：
 * @className:UserDaoImpl.java
 * @作者： David
 * @日期 2019-02-16 23:13:07
 */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
	
	public void save() {
		System.out.println("模拟持久层方法。。。");

	}

}
