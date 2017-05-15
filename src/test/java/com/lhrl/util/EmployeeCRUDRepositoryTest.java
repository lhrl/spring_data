package com.lhrl.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhrl.domain.Employee;
import com.lhrl.service.EmployeeService;

public class EmployeeCRUDRepositoryTest {

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
	
	//@Test
	public void testSave(){
		List<Employee>employees=new ArrayList<Employee>();
		Employee employee=null;
		for (int i=1;i<100;i++) {
			employee=new Employee();
			employee.setName("test"+i);
			employee.setAge(i);
			employee.setMobile("18298361462");
			employees.add(employee);
		}
		employeeService.save(employees);
	}
	
	@Test
	public void findAll(){
		List<Employee> employees=employeeService.finAll();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
}
