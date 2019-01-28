package com.david.spring4.helloworld.beans;

public class HelloWorld {
	private String name;
	public HelloWorld() {
		System.out.println("HelloWorld's constructor!");
	}
	public void hello(){
		System.out.println("hello:"+name);
	}
	public void setName(String name) {
		System.out.println("HelloWorld's setter method!");
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
