package com.david.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @描述：基于注解的方式实现日志切面的实现，需要把该类放入IOC容器中，再申明为一个切面！
 * @className:LoggingAspect.java
 * @作者： David
 * @日期 2019-02-18 21:52:53
 */
@Aspect //申明该类为一个切面
@Component 
public class LoggingAspect {
	//申明该方法是一个前置通知,在目标方法执行之前执行
	//@Before("execution(public int com.david.spring.aop.impl.AtithmeticCalculator.add(int, int))") //作用指定的方法
	//@Before("execution(public int com.david.spring.aop.impl.AtithmeticCalculator.*(int, int))") //作用所有的方法
	//@Before("execution(* com.david.spring.aop.impl.*.*(int, int))") //该包下的所有参数为2个int的所有方法
	//前置通知
	@Before("execution(* com.david.spring.aop.impl.*.*(..))") //该包下的所有类的所有方法
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins whih "+args);
	}
	
	/**
	 * 后置通知：在目标方法执行之后执行的通知(无论是否发生异常)
	 * 注意：在后置通知中还不能访问目标方法执行的结果
	 */
	@After("execution(* com.david.spring.aop.impl.*.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends whih "+args);
	}
	/**
	 * 返回通知
	 * @param joinPoint
	 */
	@AfterReturning(value="execution(* com.david.spring.aop.impl.*.*(..))",
			returning="result")
	public void AfterReturnning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" returns with "+args+"and with result : "+result);
	}
	/**
	 * 在目标方法出现异常时会执行本方法，可以访问到异常对象，可以指定在出现特定的异常时候执行该代码 比如 NullPointerException
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="execution(* com.david.spring.aop.impl.*.*(..))",
			throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" occurs exception with : "+ex);
	}
	/**
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数，环绕通知类似于动态代理的全部过程即ProceedingJoinPoint这个参数
	 * 可以决定是否执行目标方法，且环绕通知必须有返回值即为目标方法的返回值
	 * @param joinPoint
	 */
	@Around(value = "execution(* com.david.spring.aop.impl.*.*(..))")
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
