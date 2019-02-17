package com.david.spring.beans.generic.di.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.beans.generic.di.UserService;


/**
 * @描述：泛型依赖注入测试
 * @className:GenericDiTest.java
 * @作者： David
 * @日期 2019-02-17 14:29:50
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
		 * 这里，因在父类泛型依赖已经建立起对应的依赖关系了，所以userService所依赖的userDao也相应的被注入进来了
		 */
		userService.add();
	}

}
