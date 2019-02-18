package com.david.spring.aop.impl.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.aop.impl.AtithmeticCalculator;

/**
 * @描述：
 * @className:AopTest.java
 * @作者： David
 * @日期 2019-02-18 21:49:02
 */
public class AopTest {
	private ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-aop.xml");
	}
	@Test
	public void test() {
		AtithmeticCalculator aci=ac.getBean(AtithmeticCalculator.class);
		System.out.println(aci.add(1, 2));
		System.out.println(aci.div(1, 0));
	}

}
