package com.lhrl.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.lhrl.domain.Employee;
import com.lhrl.repository.EmployeePagingAndSotingRepository;

public class EmployeePagingAndSoringRepositoryTest {

	private ApplicationContext ctx=null;
	private EmployeePagingAndSotingRepository employeePagingAndSotingRepository=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("spring_data_beans.xml");
		employeePagingAndSotingRepository=ctx.getBean(EmployeePagingAndSotingRepository.class);
	}
	@After
	public void after(){
		ctx=null;
		employeePagingAndSotingRepository=null;
	}
	
	@Test
	public void findAll(){
		Order orders=new Order(Sort.Direction.DESC, "id");
		Sort sort=new Sort(orders);
		Pageable pageable=new PageRequest(0, 5,sort);
		Page<Employee>page=employeePagingAndSotingRepository.findAll(pageable);
		System.out.println("查询的总页数："+page.getTotalPages());
		System.out.println("查询的总记录数："+page.getTotalElements());
		System.out.println("当前第几页："+(page.getNumber()+1));
		System.out.println("当前页面的集合："+page.getContent());
		System.out.println("当前页面的记录数："+page.getNumberOfElements());
		
	}
}
