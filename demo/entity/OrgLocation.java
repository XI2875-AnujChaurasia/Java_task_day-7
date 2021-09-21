package com.example.demo.entity;

import javax.persistence.Entity;
import lombok.Data;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor 
@Entity

public class OrgLocation {
	@Id
	@GeneratedValue
	private int id;
	private String towerNo;
	private String floorNo;
	private String seatNo;
}
