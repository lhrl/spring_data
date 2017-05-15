package com.lhrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lhrl.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{

}
