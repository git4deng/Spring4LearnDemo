package com.david.spring.aop.helloworld.proxy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.spring.aop.helloworld.proxy.AtithmeticCalculator;
import com.david.spring.aop.helloworld.proxy.AtithmeticCalculatorImpl;
import com.david.spring.aop.helloworld.proxy.AtithmeticCalculatorImplProxy;

/**
 * @���������ڷ���ķ�ʽʵ��AOP����
 * @className:ProxyTest.java
 * @���ߣ� David
 * @���� 2019-02-17 17:14:43
 */
public class ProxyTest {

	@Test
	public void test() {
		AtithmeticCalculator target=new AtithmeticCalculatorImpl();
		AtithmeticCalculator proxy=new AtithmeticCalculatorImplProxy(target).getAtithmeticCalculatorProxy();
		int result=proxy.add(1, 2);
		System.out.println(result);
		result=proxy.sub(6, 2);
		System.out.println(result);
	}

}
