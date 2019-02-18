package com.david.spring.aop.helloworld.proxy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.spring.aop.helloworld.proxy.AtithmeticCalculator;
import com.david.spring.aop.helloworld.proxy.AtithmeticCalculatorImpl;
import com.david.spring.aop.helloworld.proxy.AtithmeticCalculatorImplProxy;

/**
 * @描述：基于反射的方式实现AOP测试
 * @className:ProxyTest.java
 * @作者： David
 * @日期 2019-02-17 17:14:43
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
