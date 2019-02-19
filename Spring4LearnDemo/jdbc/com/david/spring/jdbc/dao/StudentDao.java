package com.david.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @������jdbc��ʵ�ʿ����е�ʹ�÷�ʽ
 * @className:StudentDao.java
 * @���ߣ� David
 * @���� 2019-02-19 23:29:38
 */
@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate template;
	
	public int update(int id){
		String sql=" UPDATE DAVID_CLASS SET NAME=? WHERE ID=? ";
		int n = template.update(sql, "class-3",id);
		return n;
	}
}
