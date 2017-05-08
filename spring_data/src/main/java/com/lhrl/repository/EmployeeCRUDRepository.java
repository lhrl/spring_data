package com.lhrl.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhrl.domain.Employee;

public interface EmployeeCRUDRepository extends CrudRepository<Employee, Integer>{

}
