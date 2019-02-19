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
 * @描述：
 * @className:JDBCTest.java
 * @作者： David
 * @日期 2019-02-19 21:59:25
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
	 * 执行insert，update,delete
	 */
	@Test
	public void testUpdate(){
		String sql=" UPDATE DAVID_CLASS SET NAME=? WHERE ID=? ";
		template.update(sql, "class-3",3);
	}
	/**
	 * 执行批量insert，update,delete
	 * 注意：最后一个参数是一个Object[]的List类型，因为修改一条记录需要一个Object[]数组，那么多条就需要多条
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
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 注意不是调用这个方法：queryForObject(String sql, Class<DavidStudent> requiredType, Object... args)
	 * 注意：
	 * 1.RowMapper指定如何映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2.使用sql中的别名完成和类的属性名的映射
	 * 3.JdbcTemplate不支持级联属性，仅仅试一个JDBC的小工具，而不是ORM框架
	 */
	@Test
	public void testQueryObject(){
		String sql ="SELECT ID,NAME,AGE,GRADE,HEIGHT,SEX FROM DAVID_STUDENT WHERE ID=?";
		RowMapper<DavidStudent> rm=new BeanPropertyRowMapper<DavidStudent>(DavidStudent.class);
		DavidStudent stu = template.queryForObject(sql, rm,6);
		System.out.println(stu);
	}
	/**
	 * 查询List
	 */
	@Test
	public void testQueryList(){
		String sql ="SELECT ID,NAME,AGE,GRADE,HEIGHT,SEX FROM DAVID_STUDENT WHERE ID<?";
		RowMapper<DavidStudent> rm=new BeanPropertyRowMapper<DavidStudent>(DavidStudent.class);
		List<DavidStudent> stus = template.query(sql, rm,100);
		System.out.println(stus);
	}
	/**
	 * 获取单个的字段属性值或者统计查询
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
	 * 测试实际开发中jdbc模板使用方式
	 */
	@Test
	public void testStudentDao(){
		StudentDao stuDao = ac.getBean(StudentDao.class);
		int n = stuDao.update(4);
		System.out.println(n);
	}
	/**
	 * NamedParameterJdbcTemplate,可以给参数命名
	 * 1.好处：有多个参数则不用再对应位置了，直接对应参数名，便于维护
	 * 2.缺点：较为麻烦。
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
	 * 使用具名参数时，可以使用update(String sql, SqlParameterSource paramSource)方法进行更新操作
	 * 1.SQL中的参数名和对象的属性一致
	 * 2.使用SqlParameterSource的实现类BeanPropertySqlParameterSource实现类作为参数。
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
