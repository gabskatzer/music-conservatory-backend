package com.conservatory.presentationlayer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	@GetMapping(value = "test")
	public String getStudentData() {
		return "hey juan";
	}
}
