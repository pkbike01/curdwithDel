package com.crudoperationRestApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PatientController {

	
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping
	public ResponseEntity<?> savePatient(@RequestBody Patient patient){
		Patient newPatient = patientService.savePatient(patient);
		return new ResponseEntity<>(newPatient,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatient(){
		List<Patient> patient = patientService.getPatient();
		return ResponseEntity.ok(patient);
	
	}
	
	@DeleteMapping("/delete/{patientid}/{tenantid}/{externalref}")
	public ResponseEntity<?> deletePatient(@PathVariable("patientid") String patientid,
			@PathVariable("tenantid") String tenantid,@PathVariable("externalref") String externalref){
		Map<String , String> map = new HashMap<>();
//		if{
//			patientService.deleteByTenantidAndPatientidAndexternalref(tenantid, patientid, externalref);
//		}else {
//			
//		}
		try {
			patientService.deleteByTenantidAndPatientidAndexternalref(tenantid, patientid, externalref);
		}catch (Exception e) {
			System.out.println("patient is not present!");
			// TODO: handle exception
		}
		
		return ResponseEntity.ok("patient deleted!!");
	}
	
	
	
	
}
