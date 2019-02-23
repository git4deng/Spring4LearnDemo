package com.david.spring.transaction.xml.service.impl;

import com.david.spring.transaction.xml.dao.BookShopDao;
import com.david.spring.transaction.xml.service.BookShopService;

/**
 * @����������ע����������
 * @className:BookShopServiceImpl.java
 * @���ߣ� David
 * @���� 2019-02-22 21:56:44
 */
public class BookShopServiceImpl implements BookShopService {
	
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	public void purchase(String userName, String isbn) {
		//1.��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û������
		bookShopDao.updateUserAccount(userName, price);
	}

}
