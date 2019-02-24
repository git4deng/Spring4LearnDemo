package com.david.spring.hibernate.service;

import java.util.List;

/**
 * @描述：
 * @className:Cashier.java
 * @作者： David
 * @日期 2019-02-22 22:20:49
 */
public interface Cashier {
	public void checkout(String username,List<String> isbns);
}
