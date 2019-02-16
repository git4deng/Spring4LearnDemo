/**
 * 
 */
package com.david.spring4.helloworld.beans.cycle;

/**
 * @��������ʾspring���������ڹ���
 * @className:Car.java
 * @���ߣ� David
 * @���� 2019-02-16 20:31:42
 */
public class Car {
	
	public Car() {
		System.out.println("Car's constructor....");
	}
	private String brand;
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		System.out.println("set brand...");
		this.brand = brand;
	}
	
	public void init(){
		System.out.println("init ....");
	}
	
	public void destroy(){
		System.out.println("destroy��������");
	}
}
