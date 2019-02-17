package com.david.spring.beans.annotation.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.beans.annotation.TestObject;
import com.david.spring.beans.annotation.controller.UserController;
import com.david.spring.beans.annotation.dao.UserDao;
import com.david.spring.beans.annotation.dao.impl.UserDaoImpl;
import com.david.spring.beans.annotation.service.UserService;
import com.david.spring.beans.annotation.service.impl.UserServiceImpl;

/**
 * @描述：
 * 
 * @className:springAnnotationTest.java @作者： David
 * @日期 2019-02-16 23:22:14
 */
public class springAnnotationTest {
	private ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-annotation.xml");
	}

	@Test
	public void testObject() {
		TestObject object = ac.getBean("testObject", TestObject.class);
		System.out.println(object);
	
		UserService service = ac.getBean("userService", UserServiceImpl.class);
		System.out.println(service);
		UserDao dao = ac.getBean("userDao", UserDaoImpl.class);
		System.out.println(dao);
		UserController con = ac.getBean("userController", UserController.class);
		System.out.println(con);
	}
	@Test
	public void testObjectRelation() {
		UserController con = ac.getBean("userController", UserController.class);
		con.adduser();
	}

}
