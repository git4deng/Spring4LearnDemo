package com.david.spring.beans.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.david.spring.beans.annotation.dao.UserDao;

/**
 * @������
 * @className:UserDaoImpl.java
 * @���ߣ� David
 * @���� 2019-02-16 23:13:07
 */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
	
	public void save() {
		System.out.println("ģ��־ò㷽��������");

	}

}
