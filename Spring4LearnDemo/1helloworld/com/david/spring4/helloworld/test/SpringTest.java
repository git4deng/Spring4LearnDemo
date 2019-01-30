package com.david.spring4.helloworld.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.collections.DataSource;
import com.david.spring4.helloworld.beans.collections.Person;
import com.david.spring4.helloworld.beans.collections.PersonMap;

public class SpringTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
	}
	/**
	 * 测试集合属性List的初始化
	 */
	@Test
	public void testListProperty() {
		Person p1 = ac.getBean("p1", Person.class);
		System.out.println(p1);
	}
	/**
	 * 测试集合属性Map的初始化
	 */
	@Test
	public void testMapProperty() {
		PersonMap p2 = ac.getBean("p2", PersonMap.class);
		System.out.println(p2);
	}
	/**
	 * 测试properties
	 */
	@Test
	public void testProperty() {
		DataSource dataSource = ac.getBean("d", DataSource.class);
		System.out.println(dataSource);
	}
	/**
	 * 测试配置独立的一个集合bean，以便多个bean共同引用
	 */
	@Test
	public void testUtilList() {
		Person p3 = ac.getBean("p3", Person.class);
		System.out.println(p3);
	}
	/**
	 * 测试p命名空间简化bean的配置
	 */
	@Test
	public void testPNamespace() {
		Person p4 = ac.getBean("p4", Person.class);
		System.out.println(p4);
	}

}
