package com.david.spring.hibernate.entities;

/**
 * @描述：用户账户表
 * @className:Account.java @作者： David
 * @日期 2019-02-23 20:51:37
 */
public class Account {

	private Integer id;
	private String name;
	private int balance;

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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
