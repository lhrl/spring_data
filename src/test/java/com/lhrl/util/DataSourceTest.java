package com.lhrl.util;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourceTest {

	private ApplicationContext ctx=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	@After
	public void after(){
		ctx=null;
	}
	//@Test
	public void testDataSource(){
		DataSource dataSource=(DataSource)ctx.getBean("dataSource");
		Assert.assertNotNull(dataSource);
	}
	
	@Test
	public void testJdbcTemplate(){
		JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");
		Assert.assertNotNull(jdbcTemplate);
	}
}
