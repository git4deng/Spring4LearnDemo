package com.david.spring4.helloworld.beans.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @�������Զ����factorybeanʵ��FactoryBean�Ľӿ�
 * @className:CarFactoryBean.java
 * @���ߣ� David
 * @���� 2019-02-16 22:15:25
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Car getObject() throws Exception {
		
		return new Car(brand, 100000.00);
	}

	
	public Class<?> getObjectType() {
		
		return Car.class;
	}

	
	public boolean isSingleton() {
		
		return true;
	}

}
