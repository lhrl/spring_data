package com.lhrl.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
import org.springframework.data.jpa.domain.Specification;

import com.lhrl.domain.Employee;
import com.lhrl.repository.EmployeeJpaSpecificationExecutorRepository;

public class EmployeeJpaSprecficationExecutorRepositoryTest {

	private ApplicationContext ctx=null;
	private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository=null;
	@Before
	public void before(){
		ctx=new ClassPathXmlApplicationContext("spring_data_beans.xml");
		employeeJpaSpecificationExecutorRepository=ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
	}
	@After
	public void after(){
		ctx=null;
		employeeJpaSpecificationExecutorRepository=null;
	}
	
	@Test
	public void findAll(){
		Order orders=new Order(Sort.Direction.DESC, "id");
		Sort sort=new Sort(orders);
		Pageable pageable=new PageRequest(0, 5,sort);
		Specification<Employee>specification=new Specification<Employee>() {
			
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path path=root.get("age");
				return cb.gt(path, 50);
			}
		};
		
		Page<Employee>page=employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);
		System.out.println("查询的总页数："+page.getTotalPages());
		System.out.println("查询的总记录数："+page.getTotalElements());
		System.out.println("当前第几页："+(page.getNumber()+1));
		System.out.println("当前页面的集合："+page.getContent());
		System.out.println("当前页面的记录数："+page.getNumberOfElements());
		
	}
}
