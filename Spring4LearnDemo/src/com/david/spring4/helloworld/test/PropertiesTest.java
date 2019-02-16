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
 * @�����������ⲿproperties
 * @className:PropertiesTest.java
 * @���ߣ� David
 * @���� ����10:01:14
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
