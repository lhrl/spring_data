package com.lhrl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhrl.domain.Employee;
import com.lhrl.repository.EmployeeCRUDRepository;
import com.lhrl.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeCRUDRepository employeeCRUDRepository;
	
	@Transactional
	public void update(Integer id,String name){
		employeeRepository.update(id, name);
	}
	
	@Transactional
	public void save(List<Employee>employees){
		employeeCRUDRepository.save(employees);
	}
	
	public List<Employee>finAll(){
		List<Employee> employees=(List<Employee>) employeeCRUDRepository.findAll();
		return employees;
	}
}
