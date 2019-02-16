/**
 * 
 */
package com.david.spring4.helloworld.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @描述：bean后置处理器
 * @className:MyBeanPostProcessor.java
 * @作者： David
 * @日期 2019-02-16 21:22:04
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 参数bean：bean实例本身，beanName:bean实例的名字,返回值是实际bean,可以在这个2个方法中修改bean
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
