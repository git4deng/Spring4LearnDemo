package com.david.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @描述：泛型依赖注入的模拟service层的基本Service，在基本service层注入了泛型的DAO层，这样在其对应的子类会自动管理子类之间的依赖关系
 * @className:BaseService.java
 * @作者： David
 * @日期 2019-02-17 14:22:19
 */
public class BaseService<T> {
	@Autowired
	protected BaseDao<T> baseDao;
	
	public void add(){
		System.out.println("泛型的依赖注入。。。基础service。。。");
		System.out.println(baseDao);
	}
}
