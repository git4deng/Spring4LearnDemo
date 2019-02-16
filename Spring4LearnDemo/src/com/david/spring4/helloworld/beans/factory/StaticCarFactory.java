package com.david.spring4.helloworld.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述：静态工厂方法，直接调用一个类的静态方法就可以返回bean的实例
 * @className:StaticCarFactory.java
 * @作者： David
 * @日期 2019-02-16 21:33:48
 */
public class StaticCarFactory {
	private static Map<String,Car> cars=new HashMap<String,Car>();
	static{
		cars.put("audi", new Car("audi", 300000.00));
		cars.put("bmw", new Car("bmw", 400000.00));
		cars.put("ford", new Car("fucus", 100000.00));
	}
	/**
	 * 静态工厂方法
	 * @param name
	 * @return
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}
}
