package com.david.spring.hibernate.entities;

/**
 * @�������û��˻���
 * @className:Account.java @���ߣ� David
 * @���� 2019-02-23 20:51:37
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
