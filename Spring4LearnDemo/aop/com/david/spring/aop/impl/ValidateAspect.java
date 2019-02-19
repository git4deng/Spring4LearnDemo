package com.david.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @描述：使用order注解指定切面的优先级，值越小优先级越高
 * @className:ValidateArgs.java
 * @作者： David
 * @日期 2019-02-19 20:23:33
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	
	//@Before(value="execution(* com.david.spring.aop.impl.*.*(..))")
	/**
	 * 重用切点表达式，可以使用其它切面类定义的切点表达式
	 * @param joinPoint
	 */
	@Before(value="com.david.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("args:"+Arrays.asList(joinPoint.getArgs()));
	}
}
