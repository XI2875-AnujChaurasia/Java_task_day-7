package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;


@RestController
public class HelloController {
	
	@GetMapping("/{name}")
	public String helloWorld(@PathVariable("name") String name){
		return "Hello" +name;
		
	}


}
