package com.lhrl.util;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhrl.domain.Employee;
import com.lhrl.repository.EmployeeRepository;

public class SpringDataTest {
	private ApplicationContext ctx=null;
	
	private EmployeeRepository employeeRepository;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("spring_data_beans.xml");
		employeeRepository=ctx.getBean(EmployeeRepository.class);
	}
	@After
	public void after(){
		ctx=null;
	}
	//@Test
	public void testSpringData(){
		
	}
	
	//@Test
	public void findByName(){
		Employee employee=employeeRepository.findByName("zhangsan");
		System.out.println(employee.toString());
	}
	
	//@Test
	public void findByNameStartingWithAndAgeLessThan(){
		List<Employee> employees= employeeRepository.findByNameStartingWithAndAgeLessThan("zhan", 30);
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
	
	//@Test
	public void getEmployeeMaxId(){
		Employee employee= employeeRepository.getEmployeeMaxId();
		System.out.println(employee.toString());
	}
	
	//@Test
	public void queryParams1(){
		List<Employee> employee= employeeRepository.queryParams1("zhangsan",21);
		for (Employee employee2 : employee) {
			System.out.println(employee2.toString());
		}
	}
	
	//@Test
	public void queryParams2(){
		List<Employee> employee= employeeRepository.queryParams2("lisi",23);
		for (Employee employee2 : employee) {
			System.out.println(employee2.toString());
		}
	}
	
	//@Test
	public void queryParams3(){
		List<Employee> employee= employeeRepository.queryParams3("li");
		for (Employee employee2 : employee) {
			System.out.println(employee2.toString());
		}
	}
	
	//@Test
	public void getCount(){
		long count=employeeRepository.getCount();
		System.out.println(count);
	}
	
	@Test
	public void update(){
		employeeRepository.update(1, "admin");
	}
}