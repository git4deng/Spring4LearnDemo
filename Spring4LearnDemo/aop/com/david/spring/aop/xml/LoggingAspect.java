package com.david.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @描述：基于配置文件的方式配置AOP
 * @className:LoggingAspect.java
 * @作者： David
 * @日期 2019-02-18 21:52:53
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
			//前置通知
			System.out.println("the method "+" begins with "+args);
			obj = pjp.proceed();
			//后置通知
			System.out.println("the method "+" ends with "+args);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method "+name+" occurs exception with : "+e);
			e.printStackTrace();
		}
		//执行目标方法
		System.out.println("the method "+" returns with "+obj);
		return obj;
	}
}
