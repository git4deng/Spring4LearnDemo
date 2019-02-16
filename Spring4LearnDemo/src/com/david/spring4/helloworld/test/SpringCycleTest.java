
package com.david.spring4.helloworld.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.cycle.Car;

/**
 * @描述：Spring对bean的生命周期管理测试
 * @className:SpringCycleTest.java @作者： David
 * @日期 2019-02-16 20:35:59
 */
public class SpringCycleTest {
	/**
	 * ApplicationContext接口的子接口ClassPathXmlApplicationContext包含close方法 
	 */
	private ClassPathXmlApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-cycle.xml");
	}
    /**
     * 由此可以看出 bean的生命周期主要分为5步：
     * 1.调用构造器或者工厂方法创建Bean实例
     * 2.调用setter给属性赋值，或者调用其它bean为属性赋值
     * (postProcessBeforeInitialization)
     * 3.调用配置的init方法
     * (postProcessAfterInitialization)
     * 4.使用bean
     * 5.关闭容器调用destroy方法
     */
	@Test
	public void CycleTest() {
		Car car = ac.getBean("car", Car.class);
		System.out.println(car);
		ac.close();
	}

}
