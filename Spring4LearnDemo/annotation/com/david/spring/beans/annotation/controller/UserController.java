package com.david.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.david.spring.beans.annotation.TestObject;
import com.david.spring.beans.annotation.service.UserService;

/**
 * @描述：
 * @className:UserController.java
 * @作者： David
 * @日期 2019-02-16 23:16:11
 */
@Controller
public class UserController {
	
	/**
	 * Autowired 注解自动装配具有兼容类型的单个 Bean属性
	 *	构造器, 普通字段(即使是非 public), 一切具有参数的方法都可以应用@Authwired 注解
	 *	默认情况下, 所有使用 @Authwired 注解的属性都需要被设置. 当 Spring 找不到匹配的 Bean 装配属性时, 会抛出异常, 
	 *  若某一属性允许不被设置, 可以设置 @Authwired 注解的 required 属性为 false
	 *	默认情况下, 当 IOC 容器里存在多个类型兼容的 Bean 时, 通过类型的自动装配将无法工作. 此时可以在 @Qualifier 注解里提供 Bean 的名称. Spring 允许
	 *  对方法的入参标注 @Qualifiter 已指定注入 Bean 的名称
 	 *	@Authwired 注解也可以应用在数组类型的属性上, 此时 Spring 将会把所有匹配的 Bean 进行自动装配.
	 *	@Authwired 注解也可以应用在集合属性上, 此时 Spring 读取该集合的类型信息, 然后自动装配所有与之兼容的 Bean. 
	 *	@Authwired 注解用在 java.util.Map 上时, 若该 Map 的键值为 String, 那么 Spring 将自动装配与之 Map 值类型兼容的 Bean, 此时 Bean 
	 *  的名称作为键值
     *
	 */
	@Autowired
	private UserService userService;
	@Autowired(required=false)
	private TestObject obj1;
	public void adduser() {
		System.out.println("模拟控制层。。。");
		userService.add();
	}
}
