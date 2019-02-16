package com.david.spring4.helloworld.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.factory.Car;

/**
 * @������������������bean����
 * @className:SpringFactoryTest.java @���ߣ� David
 * @���� 2019-02-16 21:47:18
 */
public class SpringFactoryTest {

	private ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-factory.xml");
	}
	/**
	 * ��̬��������
	 */
	@Test
	public void testStaticMethod() {
		Car car = ac.getBean("car", Car.class);
		System.out.println(car);
	}
	/**
	 * ʵ��������������bean
	 */
	@Test
	public void testInstanceMethod() {
		Car car = ac.getBean("car2", Car.class);
		System.out.println(car);
	}

}
