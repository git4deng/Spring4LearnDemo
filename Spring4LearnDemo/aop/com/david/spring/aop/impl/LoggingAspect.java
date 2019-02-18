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
 * @����������ע��ķ�ʽʵ����־�����ʵ�֣���Ҫ�Ѹ������IOC�����У�������Ϊһ�����棡
 * @className:LoggingAspect.java
 * @���ߣ� David
 * @���� 2019-02-18 21:52:53
 */
@Aspect //��������Ϊһ������
@Component 
public class LoggingAspect {
	//�����÷�����һ��ǰ��֪ͨ,��Ŀ�귽��ִ��֮ǰִ��
	//@Before("execution(public int com.david.spring.aop.impl.AtithmeticCalculator.add(int, int))") //����ָ���ķ���
	//@Before("execution(public int com.david.spring.aop.impl.AtithmeticCalculator.*(int, int))") //�������еķ���
	//@Before("execution(* com.david.spring.aop.impl.*.*(int, int))") //�ð��µ����в���Ϊ2��int�����з���
	//ǰ��֪ͨ
	@Before("execution(* com.david.spring.aop.impl.*.*(..))") //�ð��µ�����������з���
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins whih "+args);
	}
	
	/**
	 * ����֪ͨ����Ŀ�귽��ִ��֮��ִ�е�֪ͨ(�����Ƿ����쳣)
	 * ע�⣺�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	 */
	@After("execution(* com.david.spring.aop.impl.*.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends whih "+args);
	}
	/**
	 * ����֪ͨ
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
	 * ��Ŀ�귽�������쳣ʱ��ִ�б����������Է��ʵ��쳣���󣬿���ָ���ڳ����ض����쳣ʱ��ִ�иô��� ���� NullPointerException
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
	 * ����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���������֪ͨ�����ڶ�̬�����ȫ�����̼�ProceedingJoinPoint�������
	 * ���Ծ����Ƿ�ִ��Ŀ�귽�����һ���֪ͨ�����з���ֵ��ΪĿ�귽���ķ���ֵ
	 * @param joinPoint
	 */
	@Around(value = "execution(* com.david.spring.aop.impl.*.*(..))")
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
