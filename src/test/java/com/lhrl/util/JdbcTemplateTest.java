package com.lhrl.util;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lhrl.dao.StudentDao;
import com.lhrl.domain.Student;

public class JdbcTemplateTest {

	
	private ApplicationContext ctx=null;
	private StudentDao studentDao=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
		studentDao=(StudentDao)ctx.getBean("studentDao");
	}
	@After
	public void after(){
		ctx=null;
	}
	@Test
	public void query(){
		List<Student>list=studentDao.query();
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
	
	//@Test
	public void testJdbcTemplate(){
		JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");
		Assert.assertNotNull(jdbcTemplate);
	}
	
	//@Test
	public void testSave(){
		Student student=new Student();
		student.setName("zhaoliu");
		student.setAge(44);
		studentDao.save(student);
	
	}
}

