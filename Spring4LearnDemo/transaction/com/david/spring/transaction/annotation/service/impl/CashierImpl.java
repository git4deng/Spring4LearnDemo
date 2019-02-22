package com.david.spring.transaction.annotation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.spring.transaction.annotation.service.BookShopService;
import com.david.spring.transaction.annotation.service.Cashier;



/**
 * @描述：
 * @className:CashierImpl.java
 * @作者： David
 * @日期 2019-02-22 22:21:58
 */
@Service("cashier")
public class CashierImpl implements Cashier {
	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	public void checkout(String userName, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(userName, isbn);
		}
	}

}
