package com.crudoperationRestApi;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM patient WHERE externalref = ?1 AND tenantid = ?2 AND patientid = ?3", nativeQuery = true)
    Patient findByExternalrefAndTenantIdAndPatientId(String externalref, String tenantId, String patientId);
    
    
    
//	@Transactional
//	void deleteByPatientIdAndTenantidAndExternalref(String patientid,String tenantid,String externalref);
}




