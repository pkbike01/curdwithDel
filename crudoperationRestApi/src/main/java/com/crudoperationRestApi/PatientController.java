package com.crudoperationRestApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PatientController {

	
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientRepository repo;
	
	
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
	
	@GetMapping("/patient/{externalref}/{tenantid}")
	public ResponseEntity<Patient> getPatientByTenantidAndExternalRef(@PathVariable("externalref") String emrid,@PathVariable String tenantid){
		System.out.println(emrid);
		System.out.println(tenantid);
		Patient patient = patientService.getPatientByTenantidAndExternalref(tenantid, emrid);
		System.out.println(patient);
		return ResponseEntity.ok(patient);
		
	}
	
	@DeleteMapping("/patient/delete/{externalref}/{tenantid}")
	public ResponseEntity<?> deletePatientByTenantidAndExternalRef(@PathVariable("externalref") String emrid, @PathVariable String tenantid){
		Map<String, String> map  = new HashMap<>();
		Patient patient = patientService.getPatientByTenantidAndExternalref(tenantid, emrid);
		if(patient!=null) {
			repo.delete(patient);
			map.put("alert", "patient has been deleted!");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}else {
			map.put("alert", "patient has not been found!");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	@GetMapping("/patients/{externalref}/{tenantid}")
	public ResponseEntity<Object> getPatientByTenantidAndExternalRefs(@PathVariable("externalref") String e,@PathVariable String tenantid){
		System.out.println("1 ...."+e);
		System.out.println(tenantid);
		Integer emrid = Integer.parseInt(e);
		System.out.println(emrid);
		System.out.println(tenantid);
		Object obj = patientService.getPatientByTenantidAndExternalrefs(tenantid, emrid);
		System.out.println(obj);
		return ResponseEntity.ok(obj);
//		return null;
		
		
	}
	//It will save list of patient.
	@SuppressWarnings("unchecked")
	@PostMapping("/patientList")
	public ResponseEntity<?> savePatientList(@RequestBody List<Patient> p ){
		Map<String,List<Object>> map = null;
		map = new HashMap<>();
		List<Object> list = new ArrayList<>();
		
		System.out.println(p);
		for(Patient pat : p) {
//			System.out.println(pat);
			Patient save = repo.save(pat);
			
			list.add("mesg saved : "+ save.getId());
			
//			System.out.println(map);
//			list.add(map);
			
		}
		map.put("result : ", list);
		System.out.println(list);
		
		return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
	}
	
    @PostMapping("/patientList/p")
    public ResponseEntity<Map<String, List<String>>> savePatientList2(@RequestBody List<Patient> patients) {
        Map<String, List<String>> result = new HashMap<>();
        List<String> messages = new ArrayList<>();
        messages.add("saved");

        patients.forEach(patient -> {
            repo.save(patient);  //Patient savedPatient = 
//            messages.add("Message saved: " + savedPatient.getId());
        });

        result.put("result", messages);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

	
	
	//Today Task create get api with search operation with pagination logic:
	
    @GetMapping("/patientinfo")
    public List<Patient> searchPatients(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page
    ) {
        
    
    if (search != null && !search.isEmpty()) {
        // Search books by title
    	Page<Patient> patientPage = repo.findBySearch(search, PageRequest.of(page, size));
        return patientPage.getContent();
    } else {
        // Get all books if no search criteria provided
        Page<Patient> bookPage = repo.findAll(PageRequest.of(page, size));
        return bookPage.getContent();
    }
    
    
    
    }
}