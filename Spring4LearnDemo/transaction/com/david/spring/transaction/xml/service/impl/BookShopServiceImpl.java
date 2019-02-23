package com.david.spring.transaction.xml.service.impl;

import com.david.spring.transaction.xml.dao.BookShopDao;
import com.david.spring.transaction.xml.service.BookShopService;

/**
 * @描述：基于注解的事务管理
 * @className:BookShopServiceImpl.java
 * @作者： David
 * @日期 2019-02-22 21:56:44
 */
public class BookShopServiceImpl implements BookShopService {
	
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	public void purchase(String userName, String isbn) {
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户的余额
		bookShopDao.updateUserAccount(userName, price);
	}

}
