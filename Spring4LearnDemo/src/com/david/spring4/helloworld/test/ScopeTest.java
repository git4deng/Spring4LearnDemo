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
	 * bean ��scope����Ĭ���ǵ����ģ������ڳ�ʼ����ʱ��ʹ������bean,��2�λ�ȡ����ͬһ�����󣬼����Ϊtrue,
	 * ���⻹��һ��scopeȡֵΪprototype,������������ʱ�򲻻ᴴ�����bean��ֻ���ڻ�ȡ��bean��ʱ��Żᴴ����
	 * �������ģ�ÿ�δ������л�ȡ�������������ᴴ��һ���µĶ���
	 */
	@Test
	public void testScope() {
		Car car1 = ac.getBean("car", Car.class);
		Car car2 = ac.getBean("car", Car.class);
		System.out.println(car1==car2);
	}
}
