package com.david.spring.aop.helloworld.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/**
 * @描述：代理类，基于反射的方式模拟AOP功能
 * @className:AtithmeticCalculatorImplProxy.java
 * @作者： David
 * @日期 2019-02-17 17:01:49
 */
public class AtithmeticCalculatorImplProxy {
	//被代理的对象
	private AtithmeticCalculator target;
	public AtithmeticCalculatorImplProxy(AtithmeticCalculator target) {
		this.target=target;
	}
	
	public AtithmeticCalculator getAtithmeticCalculatorProxy(){
		AtithmeticCalculator proxy=null;
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces=new Class[]{AtithmeticCalculator.class};
		//当调用代理对象方法的时候，该执行的代码
		InvocationHandler h=new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke....");
				return 0;
			}
		};
		proxy=(AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
	
			
		return proxy;
	} 
}
