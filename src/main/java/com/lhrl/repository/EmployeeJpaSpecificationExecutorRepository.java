package com.lhrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lhrl.domain.Employee;

public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

}
