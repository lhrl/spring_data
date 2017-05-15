package com.lhrl.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lhrl.domain.Employee;

public interface EmployeePagingAndSotingRepository extends  PagingAndSortingRepository<Employee, Integer>{
	
}
