package com.david.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * @描述：基于配置文件的方式配置AOP
 * @className:ValidateArgs.java
 * @作者： David
 * @日期 2019-02-19 20:23:33
 */
public class ValidateAspect {
	
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("args:"+Arrays.asList(joinPoint.getArgs()));
	}
}
