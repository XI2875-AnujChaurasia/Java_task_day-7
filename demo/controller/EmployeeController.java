package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.net.URISyntaxException;
import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.RequestEntity.BodyBuilder;
//import com.sun.org.apache.xerces.internal.util.URI;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.EmployeeService;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
}
	
	//Method for single id 
	//@GetMapping("/employees/{id}")
	//public Employee getEmployee(@PathVariable("id") int id) {
	//	return employeeService.getEmployee(id);
	//}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) throws URISyntaxException {
		 employeeService.save(emp);
		 URI uri = new URI("/employees/"+emp.getId());
		 System.out.println(ResponseEntity.created(uri).build());
		 return ResponseEntity.created(uri).build();
			}
	/*Before status code for delete
	 * @DeleteMapping("/employees/{id}")
	public String deleteEmp(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee deleted successfully";
	}*/
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		try{
			employeeService.delete(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//self
	/*@PutMapping("/employees/{id}")
	public String addEmployee(@RequestBody Employee emp, @PathVariable int id) {
		employeeService.update(emp,id);
		return "Emp added Successfully";
	}*/
	
	@PutMapping("/employees/{id}")
	public String updateEmp(@PathVariable("id") int id, @RequestBody Employee employee) {
		return employeeService.update(id,employee);
	}
	

}
