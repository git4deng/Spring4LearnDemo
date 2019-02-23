package com.david.spring.transaction.annotation.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.transaction.annotation.dao.BookShopDao;
import com.david.spring.transaction.annotation.service.BookShopService;
import com.david.spring.transaction.annotation.service.Cashier;


/**
 * @描述：
 * @className:BookShopTest.java
 * @作者： David
 * @日期 2019-02-22 21:36:09
 */
public class BookShopTest {
	private ApplicationContext ac;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-tx-annotation.xml");
		bookShopDao = ac.getBean("bookShopDao",BookShopDao.class);
		bookShopService = ac.getBean("bookShopService",BookShopService.class);
		cashier = ac.getBean("cashier",Cashier.class);
	}
	@Test
	public void testFindBookPriceByIsbn() {
		int n = bookShopDao.findBookPriceByIsbn("1001");
		System.out.println(n);
	}
	@Test
	public void testUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	@Test
	public void testUpdateUserAccount() {
		bookShopDao.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}
	/**
	 * 测试事务的传播行为
	 */
	@Test
	public void testCashier() {
		List<String> isbns=new ArrayList<String>();
		isbns.add("1001");
		isbns.add("1002");
		cashier.checkout("AA", isbns);
	}

}
