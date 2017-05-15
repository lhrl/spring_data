package com.lhrl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.lhrl.domain.Employee;;

@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository{

	/**
	 * 根据名字查询员工
	 * @param name
	 * @return
	 */
	public Employee findByName(String name);
	
	/**
	 * 查询以这个名字开头并且年龄小于的员工列表
	 * @param name
	 * @param age
	 * @return
	 */
	public List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);
	
	@Query("select  o from Employee o where o.id =(select max(id) from Employee t1)")
	public Employee getEmployeeMaxId();
	
	@Query("select o from Employee o where o.name=?1 and o.age=?2")
	public List<Employee> queryParams1(String name,Integer age);
	
	@Query("select o from Employee o where o.name=:name and o.age=:age")
	public List<Employee> queryParams2(@Param("name")String name,@Param(value = "age")Integer age);

	@Query("select o from Employee o where o.name like %:name%")
	public List<Employee> queryParams3(@Param("name")String name);

	@Query(nativeQuery=true,value="select count(1) from employee")
	public long getCount();
	
	@Modifying
	@Query("update Employee o set o.name=:name where o.id=:id")
	public void update(@Param("id")Integer id,@Param("name")String name);
}

