package com.david.spring.aop.helloworld.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/**
 * @�����������࣬���ڷ���ķ�ʽģ��AOP����
 * @className:AtithmeticCalculatorImplProxy.java
 * @���ߣ� David
 * @���� 2019-02-17 17:01:49
 */
public class AtithmeticCalculatorImplProxy {
	//������Ķ���
	private AtithmeticCalculator target;
	public AtithmeticCalculatorImplProxy(AtithmeticCalculator target) {
		this.target=target;
	}
	
	public AtithmeticCalculator getAtithmeticCalculatorProxy(){
		AtithmeticCalculator proxy=null;
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces=new Class[]{AtithmeticCalculator.class};
		//�����ô�����󷽷���ʱ�򣬸�ִ�еĴ���
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
