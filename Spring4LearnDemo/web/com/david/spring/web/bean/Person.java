package com.david.spring.web.bean;

/**
 * @描述：
 * 
 * @className:Person.java @作者： David
 * @日期 2019-02-24 21:23:03
 */
public class Person {
	private String username;

	public void hello(){
		System.out.println("my name is "+username);
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
