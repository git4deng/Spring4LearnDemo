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
	 * ���Լ�������List�ĳ�ʼ��
	 */
	@Test
	public void testListProperty() {
		Person p1 = ac.getBean("p1", Person.class);
		System.out.println(p1);
	}
	/**
	 * ���Լ�������Map�ĳ�ʼ��
	 */
	@Test
	public void testMapProperty() {
		PersonMap p2 = ac.getBean("p2", PersonMap.class);
		System.out.println(p2);
	}
	/**
	 * ����properties
	 */
	@Test
	public void testProperty() {
		DataSource dataSource = ac.getBean("d", DataSource.class);
		System.out.println(dataSource);
	}
	/**
	 * �������ö�����һ������bean���Ա���bean��ͬ����
	 */
	@Test
	public void testUtilList() {
		Person p3 = ac.getBean("p3", Person.class);
		System.out.println(p3);
	}
	/**
	 * ����p�����ռ��bean������
	 */
	@Test
	public void testPNamespace() {
		Person p4 = ac.getBean("p4", Person.class);
		System.out.println(p4);
	}

}
