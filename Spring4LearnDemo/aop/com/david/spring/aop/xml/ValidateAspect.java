package com.david.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * @���������������ļ��ķ�ʽ����AOP
 * @className:ValidateArgs.java
 * @���ߣ� David
 * @���� 2019-02-19 20:23:33
 */
public class ValidateAspect {
	
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("args:"+Arrays.asList(joinPoint.getArgs()));
	}
}
