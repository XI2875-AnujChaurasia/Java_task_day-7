package com.example.demo.entity;

import lombok.Data;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

import java.util.Set;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Training {
	@Id
	@GeneratedValue
	private int id;
	private String trainingName;
	//@ManyToMany(mappedBy = "trainings")
	//private Set<Employee> employees;
	

}
