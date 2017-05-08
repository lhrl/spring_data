package com.lhrl.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhrl.domain.Employee;
import com.lhrl.repository.EmployeeJpaRepository;

public class EmployeeJpaRepositoryTest {

	private ApplicationContext ctx=null;
	private EmployeeJpaRepository employeeJpaRepository=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("spring_data_beans.xml");
		employeeJpaRepository=ctx.getBean(EmployeeJpaRepository.class);
	}
	@After
	public void after(){
		ctx=null;
		employeeJpaRepository=null;
	}
	
	@Test
	public void findAll(){
		Employee employee=employeeJpaRepository.findOne(99);
			System.out.println(employee.toString());
		
	}
}
