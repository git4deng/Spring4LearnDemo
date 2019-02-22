package com.david.spring.transaction.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.david.spring.transaction.annotation.dao.BookShopDao;
import com.david.spring.transaction.annotation.service.BookShopService;



/**
 * @����������ע����������
 * @className:BookShopServiceImpl.java
 * @���ߣ� David
 * @���� 2019-02-22 21:56:44
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	/**
	 * 1.ʹ��propagationָ������Ĵ�����Ϊ������ǰ���񷽷�������һ�����񷽷�����ʱ��������ʹ������
	 * Ĭ��ȡֵΪREQUIRED����ʹ�õ��÷���������
	 * REQUIRES_NEW:ʹ���Լ������񣬵����߷��������񱻹���
	 * 2.ʹ��isolationָ��������뼶����õ�ȡֵREAD_COMMITTED�������ύ��
	 * 3.Ĭ������£�spring������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ�����Խ�������,
	 * ����ʹ��noRollbackFor={UserAccountException.class}���ö�UserAccountException�쳣�����лع���
	 * ����ͨ������£��������ȡĬ��ֵ���ɡ�
	 * 4.ʹ��read	Onlyָ�������Ƿ�Ϊֻ������ʾ�������ֻ��ȡ���ݵ�����������, �������԰������ݿ������Ż������������һ��ֻ
	 * ��ȡ���ݿ�ķ�����Ӧ����read	Only=ture
	 * 5.ʹ��timeoutָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��,��λΪ�룬�����趨ʱ�䣬����ǿ�ƻع�
	 */
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,timeout=3)
	public void purchase(String userName, String isbn) {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//1.��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û������
		bookShopDao.updateUserAccount(userName, price);
	}

}
