package com.david.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.david.spring.hibernate.dao.BookShopDao;
import com.david.spring.hibernate.exception.BookShopException;
import com.david.spring.hibernate.exception.UserAccountException;

/**
 * @������
 * 
 * @className:BookShopDaoImpl.java @���ߣ� David
 * @���� 2019-02-23 21:53:20
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * �˴����Ƽ�ʹ��HibernateTemplate��HibernateDaoSupport����Ϊ�����ᵼ��Dao��spring��api
	 * ������ϣ�����ֲ�Ա��
	 */
	// private HibernateTemplate hibernateTemplate;

	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT PRICE FROM DAVID_BOOK WHERE ISBN=?";
		Query query = getSession().createSQLQuery(hql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	public void updateBookStock(String isbn) {
		// ������֤��Ŀ��
		String hql2 = "select stock from DAVID_BOOK where isbn=?";
		Integer n = (Integer) getSession().createSQLQuery(hql2).setString(0, isbn).uniqueResult();
		if (n == 0)
			throw new BookShopException("��Ŀ�治�㣡");

		String hql = "UPDATE DAVID_BOOK SET STOCK=STOCK-1 WHERE ISBN=?";
		Query query = getSession().createSQLQuery(hql).setString(0, isbn);
		query.executeUpdate();
	}

	public void updateUserAccount(String username, int price) {
		String hql = "SELECT BALANCE FROM DAVID_ACCOUNT WHERE NAME= ?";
		int n = (Integer) getSession().createSQLQuery(hql).setString(0, username).uniqueResult();
		if (n < price)
			throw new UserAccountException("���˻����㣡");
		String hql2 = "UPDATE DAVID_ACCOUNT SET BALANCE=BALANCE-? WHERE NAME=?";
		getSession().createSQLQuery(hql2).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
