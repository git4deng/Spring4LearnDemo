package com.david.spring4.helloworld.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.david.spring4.helloworld.beans.spel.Address;
import com.david.spring4.helloworld.beans.spel.Car;
import com.david.spring4.helloworld.beans.spel.Person;

public class SpringSpelTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("application-spel.xml");
	}
	/**
	 * 测试集合属性List的初始化
	 */
	@Test
	public void testListProperty() {
		Address add = ac.getBean("address", Address.class);
		System.out.println(add);
		Car car = ac.getBean("car", Car.class);
		System.out.println(car);
		Person person = ac.getBean("person", Person.class);
		System.out.println(person);
	}
	
}
