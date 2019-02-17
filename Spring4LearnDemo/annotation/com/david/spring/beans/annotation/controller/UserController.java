package com.david.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.david.spring.beans.annotation.TestObject;
import com.david.spring.beans.annotation.service.UserService;

/**
 * @������
 * @className:UserController.java
 * @���ߣ� David
 * @���� 2019-02-16 23:16:11
 */
@Controller
public class UserController {
	
	/**
	 * Autowired ע���Զ�װ����м������͵ĵ��� Bean����
	 *	������, ��ͨ�ֶ�(��ʹ�Ƿ� public), һ�о��в����ķ���������Ӧ��@Authwired ע��
	 *	Ĭ�������, ����ʹ�� @Authwired ע������Զ���Ҫ������. �� Spring �Ҳ���ƥ��� Bean װ������ʱ, ���׳��쳣, 
	 *  ��ĳһ��������������, �������� @Authwired ע��� required ����Ϊ false
	 *	Ĭ�������, �� IOC ��������ڶ�����ͼ��ݵ� Bean ʱ, ͨ�����͵��Զ�װ�佫�޷�����. ��ʱ������ @Qualifier ע�����ṩ Bean ������. Spring ����
	 *  �Է�������α�ע @Qualifiter ��ָ��ע�� Bean ������
 	 *	@Authwired ע��Ҳ����Ӧ�����������͵�������, ��ʱ Spring ���������ƥ��� Bean �����Զ�װ��.
	 *	@Authwired ע��Ҳ����Ӧ���ڼ���������, ��ʱ Spring ��ȡ�ü��ϵ�������Ϣ, Ȼ���Զ�װ��������֮���ݵ� Bean. 
	 *	@Authwired ע������ java.util.Map ��ʱ, ���� Map �ļ�ֵΪ String, ��ô Spring ���Զ�װ����֮ Map ֵ���ͼ��ݵ� Bean, ��ʱ Bean 
	 *  ��������Ϊ��ֵ
     *
	 */
	@Autowired
	private UserService userService;
	@Autowired(required=false)
	private TestObject obj1;
	public void adduser() {
		System.out.println("ģ����Ʋ㡣����");
		userService.add();
	}
}
