package com.david.spring4.helloworld.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.autowire.Address;
import com.david.spring4.helloworld.beans.autowire.Person;


/**
 * @描述：
 * @className:AutowireTest.java
 * @作者： David
 * @日期 下午4:26:55
 */
public class AutowireTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("application-autowire.xml","application-relation.xml");
	}
	/**
	 * 手动指定属性引用的方式
	 */
	@Test
	public void testNormal() {
		Person p1 = ac.getBean("p1", Person.class);
		System.out.println(p1);
	}
	/**
	 * byname:person属性名字必须和自动装配bean的id一样，不然无法初始化属性
	 */
	@Test
	public void testAutowireByName() {
		Person p2 = ac.getBean("p2", Person.class);
		System.out.println(p2);
	}
	/**
	 * byType:根据bean的类型和当前bean的属性的类型进行自动装配
	 */
	@Test
	public void testAutowireByType() {
		Person p3 = ac.getBean("p3", Person.class);
		System.out.println(p3);
	}
	/**
	 * bean的继承：使用bean的parent属性指定继承哪个bean的配置
	 */
	@Test
	public void testRelation() {
		Address address = ac.getBean("address1", Address.class);
		System.out.println(address);
		//抽象bean不能被实例化，address2配置为抽象bean,直接获取会抛出异常
		//address = ac.getBean("address2", Address.class);
		//System.out.println(address);
		//address3继承了address1的部分属性
		address = ac.getBean("address3", Address.class);
		System.out.println(address);
		
		//2.bean的依赖
		Person person = ac.getBean("p-r", Person.class);
		System.out.println(person);
	}
	
	
	
}
