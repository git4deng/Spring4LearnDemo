package com.david.spring4.helloworld.beans.spel;

public class Person {
	private String name;
	//引用Address bean的city属性
	private String city;
	private Car car;
	//依据car的price确定info,大于30W，金领，否则白领
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
