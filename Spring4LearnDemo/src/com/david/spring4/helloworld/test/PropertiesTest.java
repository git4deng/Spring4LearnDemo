/**
 * 
 */
package com.david.spring4.helloworld.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @描述：引用外部properties
 * @className:PropertiesTest.java
 * @作者： David
 * @日期 下午10:01:14
 */
public class PropertiesTest {

private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("application-properties.xml");
	}
	@Test
	public void testProperties1() throws SQLException{
		DataSource dataSource = ac.getBean("dataSource1", DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testProperties2() throws SQLException{
		DataSource dataSource = ac.getBean("dataSource2", DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
