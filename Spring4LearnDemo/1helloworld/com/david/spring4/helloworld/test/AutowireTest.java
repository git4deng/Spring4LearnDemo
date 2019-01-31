package com.david.spring4.helloworld.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.autowire.Address;
import com.david.spring4.helloworld.beans.autowire.Person;


/**
 * @������
 * @className:AutowireTest.java
 * @���ߣ� David
 * @���� ����4:26:55
 */
public class AutowireTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("application-autowire.xml","application-relation.xml");
	}
	/**
	 * �ֶ�ָ���������õķ�ʽ
	 */
	@Test
	public void testNormal() {
		Person p1 = ac.getBean("p1", Person.class);
		System.out.println(p1);
	}
	/**
	 * byname:person�������ֱ�����Զ�װ��bean��idһ������Ȼ�޷���ʼ������
	 */
	@Test
	public void testAutowireByName() {
		Person p2 = ac.getBean("p2", Person.class);
		System.out.println(p2);
	}
	/**
	 * byType:����bean�����ͺ͵�ǰbean�����Ե����ͽ����Զ�װ��
	 */
	@Test
	public void testAutowireByType() {
		Person p3 = ac.getBean("p3", Person.class);
		System.out.println(p3);
	}
	/**
	 * bean�ļ̳У�ʹ��bean��parent����ָ���̳��ĸ�bean������
	 */
	@Test
	public void testRelation() {
		Address address = ac.getBean("address1", Address.class);
		System.out.println(address);
		//����bean���ܱ�ʵ������address2����Ϊ����bean,ֱ�ӻ�ȡ���׳��쳣
		//address = ac.getBean("address2", Address.class);
		//System.out.println(address);
		//address3�̳���address1�Ĳ�������
		address = ac.getBean("address3", Address.class);
		System.out.println(address);
		
		//2.bean������
		Person person = ac.getBean("p-r", Person.class);
		System.out.println(person);
	}
	
	
	
}
