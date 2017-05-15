package com.lhrl.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhrl.service.EmployeeService;

public class EmployeeServiceTest {

	private ApplicationContext ctx=null;
	private EmployeeService employeeService=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("spring_data_beans.xml");
		employeeService=ctx.getBean(EmployeeService.class);
	}
	@After
	public void after(){
		ctx=null;
		employeeService=null;
	}
	
	@Test
	public void update(){
		employeeService.update(1, "admin");
	}
}
