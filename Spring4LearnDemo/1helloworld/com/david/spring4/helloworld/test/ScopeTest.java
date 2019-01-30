package com.david.spring4.helloworld.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.autowire.Address;
import com.david.spring4.helloworld.beans.autowire.Car;
import com.david.spring4.helloworld.beans.autowire.Person;



public class ScopeTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("application-scope.xml");
	}
	/**
	 * bean 的scope属性默认是单例的，容器在初始化的时候就创建这个bean,即2次获取的是同一个对象，即输出为true,
	 * 另外还有一个scope取值为prototype,在容器创建的时候不会创建这个bean，只有在获取该bean的时候才会创建，
	 * 即多例的，每次从容器中获取对象，容器器都会创建一个新的对象
	 */
	@Test
	public void testScope() {
		Car car1 = ac.getBean("car", Car.class);
		Car car2 = ac.getBean("car", Car.class);
		System.out.println(car1==car2);
	}
}
