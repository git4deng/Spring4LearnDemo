package com.david.spring.jdbc.bean;

/**
 * @������
 * @className:DavidClass.java
 * @���ߣ� David
 * @���� 2019-02-19 22:23:42
 */
public class DavidClass {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DavidClass [id=" + id + ", name=" + name + "]";
	}
	
	
}
