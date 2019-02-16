package com.david.spring4.helloworld.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述：实例工厂方法,即需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 * @className:InstanceCarFactory.java @作者： David
 * @日期 2019-02-16 21:53:07
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
