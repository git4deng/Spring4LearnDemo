package com.david.spring.aop.helloworld.proxy;

/**
 * @描述：被代理的接口
 * @className:AtithmeticCalculator.java
 * @作者： David
 * @日期 2019-02-17 14:45:18
 */
public interface AtithmeticCalculator {
	int add(int i,int j);
	int sub(int i,int j);
	int mul(int i,int j);
	int div(int i,int j);
}
