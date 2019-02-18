package com.david.spring.aop.helloworld;

/**
 * @描述：模拟日志记录功能，缺点代码冗余，修改麻烦
 * @className:AtithmeticCalculatorImpl.java
 * @作者： David
 * @日期 2019-02-17 14:46:16
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
