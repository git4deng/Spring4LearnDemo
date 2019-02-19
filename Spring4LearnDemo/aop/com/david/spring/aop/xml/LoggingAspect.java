package com.david.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @���������������ļ��ķ�ʽ����AOP
 * @className:LoggingAspect.java
 * @���ߣ� David
 * @���� 2019-02-18 21:52:53
 */ 
public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins whih "+args);
	}
	
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends whih "+args);
	}
	
	
	public void AfterReturnning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" returns with "+args+"and with result : "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" occurs exception with : "+ex);
	}
	
	public Object AroundMethod(ProceedingJoinPoint pjp){
		//return 1;
		Object obj=null;
		String name = pjp.getSignature().getName();
		List<Object> args = Arrays.asList(pjp.getArgs());
		try {
			//ǰ��֪ͨ
			System.out.println("the method "+" begins with "+args);
			obj = pjp.proceed();
			//����֪ͨ
			System.out.println("the method "+" ends with "+args);
		} catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("The method "+name+" occurs exception with : "+e);
			e.printStackTrace();
		}
		//ִ��Ŀ�귽��
		System.out.println("the method "+" returns with "+obj);
		return obj;
	}
}
