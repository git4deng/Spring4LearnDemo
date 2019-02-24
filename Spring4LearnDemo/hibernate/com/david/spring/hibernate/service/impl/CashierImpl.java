package com.david.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.hibernate.service.BookShopService;
import com.david.spring.hibernate.service.Cashier;

/**
 * @描述：
 * 
 * @className:CashierImpl.java @作者： David
 * @日期 2019-02-23 22:19:55
 */
@Service("cashier")
public class CashierImpl implements Cashier {
	@Autowired
	private BookShopService bookShopService;

	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}

	}

}
