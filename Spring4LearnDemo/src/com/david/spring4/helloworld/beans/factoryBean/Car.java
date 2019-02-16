package com.david.spring4.helloworld.beans.factoryBean;

/**
 * @����������������Ӧbean����
 * @className:Car.java
 * @���ߣ� David
 * @���� 2019-02-16 21:34:48
 */
public class Car {
	private String brand;
	private double price;
	
	
	public Car() {
		
	}
	
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
	
}
