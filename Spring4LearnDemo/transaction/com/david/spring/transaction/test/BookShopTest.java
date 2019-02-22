package com.david.spring.transaction.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.david.spring.transaction.dao.BookShopDao;
import com.david.spring.transaction.service.BookShopService;

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
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-tx.xml");
		bookShopDao = ac.getBean("bookShopDao",BookShopDao.class);
		bookShopService = ac.getBean("bookShopService",BookShopService.class);
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

}
