package com.david.spring.hibernate.service;

import java.util.List;

/**
 * @������
 * @className:Cashier.java
 * @���ߣ� David
 * @���� 2019-02-22 22:20:49
 */
public interface Cashier {
	public void checkout(String username,List<String> isbns);
}
