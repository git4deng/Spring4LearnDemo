package com.david.spring.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.transaction.dao.BookShopDao;
import com.david.spring.transaction.service.BookShopService;

/**
 * @描述：
 * @className:BookShopServiceImpl.java
 * @作者： David
 * @日期 2019-02-22 21:56:44
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	public void purchase(String userName, String isbn) {
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户的余额
		bookShopDao.updateUserAccount(userName, price);
	}

}
