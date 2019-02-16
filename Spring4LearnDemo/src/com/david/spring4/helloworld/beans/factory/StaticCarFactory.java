package com.david.spring4.helloworld.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @��������̬����������ֱ�ӵ���һ����ľ�̬�����Ϳ��Է���bean��ʵ��
 * @className:StaticCarFactory.java
 * @���ߣ� David
 * @���� 2019-02-16 21:33:48
 */
public class StaticCarFactory {
	private static Map<String,Car> cars=new HashMap<String,Car>();
	static{
		cars.put("audi", new Car("audi", 300000.00));
		cars.put("bmw", new Car("bmw", 400000.00));
		cars.put("ford", new Car("fucus", 100000.00));
	}
	/**
	 * ��̬��������
	 * @param name
	 * @return
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}
}
