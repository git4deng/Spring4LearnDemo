package com.david.spring.transaction.xml.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.david.spring.transaction.xml.dao.BookShopDao;
import com.david.spring.transaction.xml.exception.BookShopException;
import com.david.spring.transaction.xml.exception.UserAccountException;





/**
 * @描述：
 * @className:BookShopDaoImpl.java
 * @作者： David
 * @日期 2019-02-22 21:23:12
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private JdbcTemplate template;
	public int findBookPriceByIsbn(String isbn) {
		String sql="select price from book where isbn=? ";
		int n =template.queryForObject(sql, Integer.class,isbn);
		return n;
	}
	public void updateBookStock(String isbn) {
		//验证书的库存是否足够，不足够就抛出异常
		String sql2="select stock from book_stock  where isbn=?";
		Integer n = template.queryForObject(sql2, Integer.class,isbn);
		if(n==0){
			throw new BookShopException("书的库存不足！");
		}
		String sql="update book_stock set stock=stock-1 where isbn=?";
		template.update(sql,isbn);
		
	}

	
	public void updateUserAccount(String username, int price) {
		//验证账户余额是否足够，如果不足则抛出异常
		String sql2="select balance from account where username=? ";
		Integer n = template.queryForObject(sql2, Integer.class,username);
		if(n<price) throw new UserAccountException("用户账户余额不足！");
		String sql="update account set balance=balance-? where username=?";
		template.update(sql,price,username);
		
	}

}
