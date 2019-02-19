package com.david.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @������ʹ��orderע��ָ����������ȼ���ֵԽС���ȼ�Խ��
 * @className:ValidateArgs.java
 * @���ߣ� David
 * @���� 2019-02-19 20:23:33
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	
	//@Before(value="execution(* com.david.spring.aop.impl.*.*(..))")
	/**
	 * �����е���ʽ������ʹ�����������ඨ����е���ʽ
	 * @param joinPoint
	 */
	@Before(value="com.david.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("args:"+Arrays.asList(joinPoint.getArgs()));
	}
}
