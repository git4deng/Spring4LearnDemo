package com.david.spring.jdbc.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.david.spring.jdbc.bean.DavidClass;
import com.david.spring.jdbc.bean.DavidStudent;
import com.david.spring.jdbc.dao.StudentDao;


/**
 * @������
 * @className:JDBCTest.java
 * @���ߣ� David
 * @���� 2019-02-19 21:59:25
 */
public class JDBCTest {
	private ApplicationContext ac;
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate nptemplate;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-jdbc.xml");
		template=ac.getBean("jdbcTemplate",JdbcTemplate.class);
		nptemplate=ac.getBean("namedParameterJdbcTemplate",NamedParameterJdbcTemplate.class);
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ac.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	/**
	 * ִ��insert��update,delete
	 */
	@Test
	public void testUpdate(){
		String sql=" UPDATE DAVID_CLASS SET NAME=? WHERE ID=? ";
		template.update(sql, "class-3",3);
	}
	/**
	 * ִ������insert��update,delete
	 * ע�⣺���һ��������һ��Object[]��List���ͣ���Ϊ�޸�һ����¼��Ҫһ��Object[]���飬��ô��������Ҫ����
	 */
	@Test
	public void testBatchUpdate(){
		String sql=" INSERT DAVID_CLASS VALUES(?,?) ";
		List<Object[]> args=new ArrayList<Object[]>();
		
		args.add(new Object[]{1,"class-1"});
		args.add(new Object[]{4,"class-4"});
		args.add(new Object[]{5,"class-5"});
		args.add(new Object[]{6,"class-6"});
		template.batchUpdate(sql, args);
	}
	/**
	 * �����ݿ��л�ȡһ����¼��ʵ�ʵõ���Ӧ��һ������
	 * ע�ⲻ�ǵ������������queryForObject(String sql, Class<DavidStudent> requiredType, Object... args)
	 * ע�⣺
	 * 1.RowMapperָ�����ӳ���������У����õ�ʵ����ΪBeanPropertyRowMapper
	 * 2.ʹ��sql�еı�����ɺ������������ӳ��
	 * 3.JdbcTemplate��֧�ּ������ԣ�������һ��JDBC��С���ߣ�������ORM���
	 */
	@Test
	public void testQueryObject(){
		String sql ="SELECT ID,NAME,AGE,GRADE,HEIGHT,SEX FROM DAVID_STUDENT WHERE ID=?";
		RowMapper<DavidStudent> rm=new BeanPropertyRowMapper<DavidStudent>(DavidStudent.class);
		DavidStudent stu = template.queryForObject(sql, rm,6);
		System.out.println(stu);
	}
	/**
	 * ��ѯList
	 */
	@Test
	public void testQueryList(){
		String sql ="SELECT ID,NAME,AGE,GRADE,HEIGHT,SEX FROM DAVID_STUDENT WHERE ID<?";
		RowMapper<DavidStudent> rm=new BeanPropertyRowMapper<DavidStudent>(DavidStudent.class);
		List<DavidStudent> stus = template.query(sql, rm,100);
		System.out.println(stus);
	}
	/**
	 * ��ȡ�������ֶ�����ֵ����ͳ�Ʋ�ѯ
	 */
	@Test
	public void testQueryForObject(){
		String sql="SELECT COUNT(ID) FROM DAVID_STUDENT ";
		long size = template.queryForLong(sql);
		System.out.println(size);
		size =template.queryForObject(sql, Long.class);
		System.out.println(size);
	}
	/**
	 * ����ʵ�ʿ�����jdbcģ��ʹ�÷�ʽ
	 */
	@Test
	public void testStudentDao(){
		StudentDao stuDao = ac.getBean(StudentDao.class);
		int n = stuDao.update(4);
		System.out.println(n);
	}
	/**
	 * NamedParameterJdbcTemplate,���Ը���������
	 * 1.�ô����ж�����������ٶ�Ӧλ���ˣ�ֱ�Ӷ�Ӧ������������ά��
	 * 2.ȱ�㣺��Ϊ�鷳��
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql="INSERT INTO DAVID_CLASS (ID,NAME) VALUES (:id,:name) ";
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", 7);
		paramMap.put("name", "class-7");
		int n = nptemplate.update(sql, paramMap);
		System.out.println(n);
	}
	/**
	 * ʹ�þ�������ʱ������ʹ��update(String sql, SqlParameterSource paramSource)�������и��²���
	 * 1.SQL�еĲ������Ͷ��������һ��
	 * 2.ʹ��SqlParameterSource��ʵ����BeanPropertySqlParameterSourceʵ������Ϊ������
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql="INSERT INTO DAVID_CLASS (ID,NAME) VALUES (:id,:name) ";
		DavidClass dc=new DavidClass();
		dc.setId(8);
		dc.setName("class-8");
		
		SqlParameterSource sps=new BeanPropertySqlParameterSource(dc);
		int n = nptemplate.update(sql, sps);
		System.out.println(n);
	}
}
