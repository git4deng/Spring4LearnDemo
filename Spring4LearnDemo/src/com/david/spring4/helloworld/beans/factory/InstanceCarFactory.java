package com.david.spring4.helloworld.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @������ʵ����������,����Ҫ�������������ٵ��ù�����ʵ������������bean��ʵ��
 * @className:InstanceCarFactory.java @���ߣ� David
 * @���� 2019-02-16 21:53:07
 */
public class InstanceCarFactory {
	private Map<String, Car> cars = null;

	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("audi", 300000.00));
		cars.put("bmw", new Car("bmw", 400000.00));
	}

	public Car getCar(String name) {
		return cars.get(name);
	}
}
