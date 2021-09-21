package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployees() {
		//Paging and sorting Example
	//	Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
	//	Page<Employee> page = employeeRepository.findAll(pageable);
	//	return page.toList();
		
		
		//System.out.println(employeeRepository.getAllEmpCount());
		return employeeRepository.findAll();
		}

	public void save(Employee emp) {
		employeeRepository.save(emp);
	}

	public void delete(int id) {
		employeeRepository.deleteById(id);
			}

	/*public String update(int id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	public Employee getEmployee(int id) {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if(optEmp.isPresent()) {
			return optEmp.get();
		}else {
			return null;
		}
	}
	
//specific obj to specific index
	public String update(int id, Employee employee) {
		
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if(optEmp.isPresent()) {
			Employee emp = optEmp.get();
			emp.setName(employee.getName());
			//emp.setEmail(employee.getEmail());
			emp.setSalary(employee.getSalary());
			employeeRepository.save(emp);
			return "Employee updated successfully with Id " +emp.getId();
		}else {
			return "Employee not present with Id " +id;
		}
	}
	


}