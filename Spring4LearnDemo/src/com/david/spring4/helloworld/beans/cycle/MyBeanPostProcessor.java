/**
 * 
 */
package com.david.spring4.helloworld.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @������bean���ô�����
 * @className:MyBeanPostProcessor.java
 * @���ߣ� David
 * @���� 2019-02-16 21:22:04
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/**
	 * ����bean��beanʵ������beanName:beanʵ��������,����ֵ��ʵ��bean,���������2���������޸�bean
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean+","+beanName);
		return bean;
	}

	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean+","+beanName);
		return bean;
	}

}
