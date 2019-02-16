package com.david.spring4.helloworld.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.factoryBean.Car;



/**
 * @描述：工厂方法配置bean测试
 * @className:SpringFactoryTest.java @作者： David
 * @日期 2019-02-16 21:47:18
 */
public class SpringFactoryBeanTest {

	private ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-factorybean.xml");
	}
	/**
	 * factoryBean的方式
	 */
	@Test
	public void factoryBeanTest() {
		Car car = ac.getBean("car", Car.class);
		System.out.println(car);
	}
	

}
