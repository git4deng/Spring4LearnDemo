package com.david.spring.transaction.dao;

/**
 * @������
 * @className:BookDao.java
 * @���ߣ� David
 * @���� 2019-02-22 21:06:51
 */
public interface BookShopDao {
	/**
	 * ͨ����Ż�ȡ��ĵ���
	 * @param isbn
	 * @return
	 */
	public int findBookPriceByIsbn(String isbn);
	/**
	 * ͨ����Ÿ�����Ŀ��
	 * @param isbn
	 */
	public void updateBookStock(String isbn);
	/**
	 * �����û����˻����
	 * @param username
	 * @param price
	 */
	public void updateUserAccount(String username,int price);
}
