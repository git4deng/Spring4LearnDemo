package com.david.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @��������������ע���ģ��service��Ļ���Service���ڻ���service��ע���˷��͵�DAO�㣬���������Ӧ��������Զ���������֮���������ϵ
 * @className:BaseService.java
 * @���ߣ� David
 * @���� 2019-02-17 14:22:19
 */
public class BaseService<T> {
	@Autowired
	protected BaseDao<T> baseDao;
	
	public void add(){
		System.out.println("���͵�����ע�롣��������service������");
		System.out.println(baseDao);
	}
}
