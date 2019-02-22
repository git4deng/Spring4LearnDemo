package com.david.spring.transaction.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.david.spring.transaction.annotation.dao.BookShopDao;
import com.david.spring.transaction.annotation.service.BookShopService;



/**
 * @描述：基于注解的事务管理
 * @className:BookShopServiceImpl.java
 * @作者： David
 * @日期 2019-02-22 21:56:44
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	/**
	 * 1.使用propagation指定事务的传播行为，即当前事务方法被另外一个事务方法调用时，如何如何使用事务，
	 * 默认取值为REQUIRED，即使用调用方法的事务。
	 * REQUIRES_NEW:使用自己的事务，调用者方法的事务被挂起
	 * 2.使用isolation指定事务隔离级别，最常用的取值READ_COMMITTED即读已提交。
	 * 3.默认情况下，spring的申明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置,
	 * 例如使用noRollbackFor={UserAccountException.class}配置对UserAccountException异常不进行回滚，
	 * 但是通常情况下，这个属性取默认值即可。
	 * 4.使用read	Only指定事务是否为只读。表示这个事务只读取数据但不更新数据, 这样可以帮助数据库引擎优化事务。若真的是一个只
	 * 读取数据库的方法，应设置read	Only=ture
	 * 5.使用timeout指定强制回滚之前事务可以占用的时间,单位为秒，超过设定时间，事务强制回滚
	 */
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,timeout=3)
	public void purchase(String userName, String isbn) {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户的余额
		bookShopDao.updateUserAccount(userName, price);
	}

}
