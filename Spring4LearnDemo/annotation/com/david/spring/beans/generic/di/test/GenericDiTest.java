package com.david.spring.beans.generic.di.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.beans.generic.di.UserService;


/**
 * @��������������ע�����
 * @className:GenericDiTest.java
 * @���ߣ� David
 * @���� 2019-02-17 14:29:50
 */
public class GenericDiTest {
	
	private ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-annotation-generic-di.xml");
	}
	@Test
	public void test() {
		UserService userService = ac.getBean("userService", UserService.class);
		System.out.println(userService);
		/**
		 * ������ڸ��෺�������Ѿ��������Ӧ��������ϵ�ˣ�����userService��������userDaoҲ��Ӧ�ı�ע�������
		 */
		userService.add();
	}

}
