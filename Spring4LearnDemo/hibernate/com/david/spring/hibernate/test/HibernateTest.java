package com.david.spring.hibernate.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.hibernate.service.BookShopService;
import com.david.spring.hibernate.service.Cashier;

/**
 * @������spring����hibernate�Ĳ�����
 * @className:HibernateTest.java @���ߣ� David
 * @���� 2019-02-23 21:11:38
 */
public class HibernateTest {
	private ApplicationContext ac;
	private BookShopService bookShopService;
	private Cashier cashier;
	{
		ac = new ClassPathXmlApplicationContext("application-hibernate.xml");
		bookShopService=ac.getBean(BookShopService.class);
		cashier=ac.getBean(Cashier.class);
	}

	@Test
	public void test() throws SQLException {
		DataSource dataSource = ac.getBean("dataSource",DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	/**
	 * ��������Ĵ�����Ϊ
	 */
	@Test
	public void testCashier() {
		List<String> isbns=new ArrayList<String>();
		isbns.add("1001");
		isbns.add("1002");
		cashier.checkout("AA", isbns);
	}
}
