package com.david.spring.aop.helloworld;

/**
 * @������ģ����־��¼���ܣ�ȱ��������࣬�޸��鷳
 * @className:AtithmeticCalculatorImpl.java
 * @���ߣ� David
 * @���� 2019-02-17 14:46:16
 */
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

	
	public int add(int i, int j) {
		System.out.println("The method add begins with ["+i+","+j+"]");
		return i+j;
	}

	
	public int sub(int i, int j) {
		System.out.println("The method sub begins with ["+i+","+j+"]");
		return i-j;
	}

	
	public int mul(int i, int j) {
		System.out.println("The method mul begins with ["+i+","+j+"]");
		return i*j;
	}

	
	public int div(int i, int j) {
		System.out.println("The method div begins with ["+i+","+j+"]");
		return i/j;
	}

}
