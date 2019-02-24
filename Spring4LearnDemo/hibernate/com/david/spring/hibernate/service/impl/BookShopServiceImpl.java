package com.david.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.spring.hibernate.dao.BookShopDao;
import com.david.spring.hibernate.service.BookShopService;

/**
 * @������
 * 
 * @className:BookShopServiceImpl.java @���ߣ� David
 * @���� 2019-02-23 22:16:34
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	/**
	 * Spring hibernate ���������
	 * 1. �ڷ�����ʼ֮ǰ
	 * ��. ��ȡ Session
	 * ��. �� Session �͵�ǰ�̰߳�, �����Ϳ����� Dao ��ʹ�� SessionFactory ��
	 * getCurrentSession() ��������ȡ Session ��
	 * ��. ��������
	 * 
	 * 2. ��������������, ��û�г����쳣, ��
	 * ��. �ύ����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
	 * 
	 * 3. �����������쳣, ��:
	 * ��. �ع�����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
	 */
	public void purchase(String userName, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(userName, price);

	}

}
