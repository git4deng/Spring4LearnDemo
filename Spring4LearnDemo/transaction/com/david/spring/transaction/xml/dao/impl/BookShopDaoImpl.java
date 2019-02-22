package com.david.spring.transaction.xml.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.david.spring.transaction.xml.dao.BookShopDao;
import com.david.spring.transaction.xml.exception.BookShopException;
import com.david.spring.transaction.xml.exception.UserAccountException;





/**
 * @������
 * @className:BookShopDaoImpl.java
 * @���ߣ� David
 * @���� 2019-02-22 21:23:12
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
		//��֤��Ŀ���Ƿ��㹻�����㹻���׳��쳣
		String sql2="select stock from book_stock  where isbn=?";
		Integer n = template.queryForObject(sql2, Integer.class,isbn);
		if(n==0){
			throw new BookShopException("��Ŀ�治�㣡");
		}
		String sql="update book_stock set stock=stock-1 where isbn=?";
		template.update(sql,isbn);
		
	}

	
	public void updateUserAccount(String username, int price) {
		//��֤�˻�����Ƿ��㹻������������׳��쳣
		String sql2="select balance from account where username=? ";
		Integer n = template.queryForObject(sql2, Integer.class,username);
		if(n<price) throw new UserAccountException("�û��˻����㣡");
		String sql="update account set balance=balance-? where username=?";
		template.update(sql,price,username);
		
	}

}
