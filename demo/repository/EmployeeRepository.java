package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//@Query(nativeQuery = true, value= "select count(*) from employee")
	@Query(nativeQuery = true, value= "select sum(salary) from employee")
	public long getAllEmpCount();

}
