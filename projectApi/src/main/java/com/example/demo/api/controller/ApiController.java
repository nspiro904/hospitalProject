package com.example.demo.api.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.Department;
import com.example.demo.api.model.HealthRecord;
import com.example.demo.api.model.Patient;
import com.example.demo.service.ApiService;

@CrossOrigin
@RestController
public class ApiController {

	private ApiService apiService;
	
	@Autowired
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	
	@GetMapping("/patient-record")
	public HealthRecord getHealthRecord(@RequestParam String id) {
		HealthRecord record = null;
		try {
			record = apiService.getHealthRecord(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}
	
	@PostMapping("/add-patient")
	public Boolean addPatient(@RequestBody Patient patient) {
		
//		try {
//			apiService
//		}
		
		return null;
	}
	
	@PostMapping("/add-department")
	public Boolean addDepartment(@RequestBody Department d) {
		Boolean success = false;
		
		try {
		success = apiService.addDepartment(d);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
}
