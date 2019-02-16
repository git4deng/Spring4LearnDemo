
package com.david.spring4.helloworld.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.cycle.Car;

/**
 * @������Spring��bean���������ڹ������
 * @className:SpringCycleTest.java @���ߣ� David
 * @���� 2019-02-16 20:35:59
 */
public class SpringCycleTest {
	/**
	 * ApplicationContext�ӿڵ��ӽӿ�ClassPathXmlApplicationContext����close���� 
	 */
	private ClassPathXmlApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-cycle.xml");
	}
    /**
     * �ɴ˿��Կ��� bean������������Ҫ��Ϊ5����
     * 1.���ù��������߹�����������Beanʵ��
     * 2.����setter�����Ը�ֵ�����ߵ�������beanΪ���Ը�ֵ
     * (postProcessBeforeInitialization)
     * 3.�������õ�init����
     * (postProcessAfterInitialization)
     * 4.ʹ��bean
     * 5.�ر���������destroy����
     */
	@Test
	public void CycleTest() {
		Car car = ac.getBean("car", Car.class);
		System.out.println(car);
		ac.close();
	}

}
