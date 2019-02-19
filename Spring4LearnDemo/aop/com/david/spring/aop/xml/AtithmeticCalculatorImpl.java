package com.david.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @描述：
 * @className:AtithmeticCalculatorImpl.java
 * @作者： David
 * @日期 2019-02-17 14:46:16
 */
@Component
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

	
	public int add(int i, int j) {
		
		return i+j;
	}

	
	public int sub(int i, int j) {
		
		return i-j;
	}

	
	public int mul(int i, int j) {
		
		return i*j;
	}

	
	public int div(int i, int j) {
		
		return i/j;
	}

}
