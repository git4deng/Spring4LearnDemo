package com.david.spring4.helloworld.beans.spel;

public class Person {
	private String name;
	//����Address bean��city����
	private String city;
	private Car car;
	//����car��priceȷ��info,����30W�����죬�������
	private String info;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", car=" + car + ", info=" + info + "]";
	}
	
	
}
