package com.crudoperationRestApi;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PatientService_Impl implements PatientService{

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public Patient savePatient(Patient patient) {
		Patient newPatient = patientRepo.save(patient);
		return newPatient;
	}

	@Override
	public List<Patient> getPatient() {
		List<Patient> findAll = patientRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteByTenantidAndPatientidAndexternalref(String tenantId, String patientid, String externalref) {
		 Patient patient = patientRepo.findByExternalrefAndTenantIdAndPatientId(externalref, tenantId, patientid);
	        if(patient != null) {
	            patientRepo.delete(patient);
	        } else {
	            throw new EntityNotFoundException("Patient not found with externalref " + externalref + ", tenantId " + tenantId + ", and patientId " + patientid);
	        }
	 }
	

}
