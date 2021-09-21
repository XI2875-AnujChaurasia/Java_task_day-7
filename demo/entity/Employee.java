package com.example.demo.entity;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="org_loc_id")
	private OrgLocation orgLocation;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Set<EmployeeDetails> empDetails;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;

	@ManyToMany
	@JoinTable(name="employee_training",
	joinColumns= @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="training_id"))
	private Set<Training> trainings;

}
