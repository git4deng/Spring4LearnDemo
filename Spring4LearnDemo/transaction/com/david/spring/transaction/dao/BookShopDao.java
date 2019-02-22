package com.david.spring.transaction.dao;

/**
 * @描述：
 * @className:BookDao.java
 * @作者： David
 * @日期 2019-02-22 21:06:51
 */
public interface BookShopDao {
	/**
	 * 通过书号获取书的单价
	 * @param isbn
	 * @return
	 */
	public int findBookPriceByIsbn(String isbn);
	/**
	 * 通过书号更新书的库存
	 * @param isbn
	 */
	public void updateBookStock(String isbn);
	/**
	 * 更新用户的账户余额
	 * @param username
	 * @param price
	 */
	public void updateUserAccount(String username,int price);
}
