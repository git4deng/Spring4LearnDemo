package com.david.spring.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.transaction.dao.BookShopDao;
import com.david.spring.transaction.service.BookShopService;

/**
 * @������
 * @className:BookShopServiceImpl.java
 * @���ߣ� David
 * @���� 2019-02-22 21:56:44
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	public void purchase(String userName, String isbn) {
		//1.��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û������
		bookShopDao.updateUserAccount(userName, price);
	}

}
