package com.david.spring.aop.helloworld.proxy;

/**
 * @���������������ʵ����
 * @className:AtithmeticCalculatorImpl.java
 * @���ߣ� David
 * @���� 2019-02-17 14:46:16
 */
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
