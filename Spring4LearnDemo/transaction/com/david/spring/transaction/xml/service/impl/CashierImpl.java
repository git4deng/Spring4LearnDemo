package com.david.spring.transaction.xml.service.impl;

import java.util.List;

import com.david.spring.transaction.xml.service.BookShopService;
import com.david.spring.transaction.xml.service.Cashier;

/**
 * @������
 * @className:CashierImpl.java
 * @���ߣ� David
 * @���� 2019-02-22 22:21:58
 */

public class CashierImpl implements Cashier {
	
	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	public void checkout(String userName, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(userName, isbn);
		}
	}

}
