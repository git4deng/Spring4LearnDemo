package com.david.spring.aop.helloworld.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.david.spring.aop.helloworld.AtithmeticCalculator;
import com.david.spring.aop.helloworld.AtithmeticCalculatorImpl;

/**
 * @描述：
 * @className:AtithmeticCalculator.java
 * @作者： David
 * @日期 2019-02-17 16:57:21
 */
public class AtithmeticCalculatorTest {

	@Test
	public void test1() {
		AtithmeticCalculatorImpl ca=new AtithmeticCalculatorImpl();
		int result=ca.add(1, 2);
		System.out.println(result);
		result=ca.sub(6, 2);
		System.out.println(result);

	}
}
