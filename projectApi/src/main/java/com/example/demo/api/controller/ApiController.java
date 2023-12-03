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
import com.example.demo.api.model.Doctor;
import com.example.demo.api.model.HealthRecord;
import com.example.demo.api.model.Interaction;
import com.example.demo.api.model.Medication;
import com.example.demo.api.model.Patient;
import com.example.demo.api.model.Prescription;
import com.example.demo.api.model.Procedure;
import com.example.demo.api.model.ProcedureRecord;
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
		
		Boolean success = false;
		try {
			success = apiService.addPatient(patient);
		}
		catch( SQLException e){
			e.printStackTrace();
		}
		
		return success;
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
	
	@PostMapping("/add-medication")
	public Boolean addMedication(@RequestBody Medication m) {
		Boolean success = false;
		
		try {
		success = apiService.addMedication(m);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@PostMapping("/add-interaction")
	public Boolean addInteraction(@RequestBody Interaction interaction) {
		Boolean success = false;
		
		try {
		success = apiService.addInteraction(interaction);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@PostMapping("/add-doctor")
	public Boolean addDepartment(@RequestBody Doctor d) {
		Boolean success = false;
		
		try {
		success = apiService.addDoctor(d);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@PostMapping("/add-procedure")
	public Boolean addProcedure(@RequestBody Procedure p) {
		Boolean success = false;
		
		try {
		success = apiService.addProcedure(p);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@PostMapping("/record-procedure")
	public Boolean recordProcedure(@RequestBody ProcedureRecord r) {
		
		Boolean success = false;

		try {
			success = apiService.recordProcedure(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	@PostMapping("/add-prescription")
	public Boolean addPrescription(@RequestBody Prescription p) {
		
		Boolean success = false;

		try {
			success = apiService.addPrescription(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	@GetMapping("/get-procedures-code")
	public Object[] getProcedures(@RequestParam String dcode ){

		return apiService.getProceduresCode(dcode);

	}

	@GetMapping("/doctor-procedures")
	public Object[] getDoctorProcedures(@RequestParam String did) {

		return apiService.getProceduresDoctor(did);
	}
}
