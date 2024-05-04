package com.crudoperationRestApi;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM patient WHERE externalref = ?1 AND tenantid = ?2 AND patientid = ?3", nativeQuery = true)
    Patient findByExternalrefAndTenantIdAndPatientId(String externalref, String tenantId, String patientId);
//    
    
    
//	@Transactional
	//void deleteByPatientIdAndTenantidAndExternalref(String patientid,String tenantid,String externalref);
	
	@Query(value="SELECT * FROM patients WHERE externalref ->> 'emrid' = :emrid AND tenantid = :tenantid", nativeQuery=true)
	Patient findPatientByTenantidAndExternalref(@Param("tenantid") String tenantid, @Param("emrid") String emrid);


//	Page<Patient> findByTitleContainingIgnoreCase(String title, PageRequest of);


//	@Query(value = "SELECT * FROM patients p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
//    Page<Patient> findBySearch(@Param("name") String name, PageRequest of);
	
	
//	SELECT * FROM patients p WHERE LOWER(p.name) "
//	+ "LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR) || LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%'))
	
//	@Query(value = "SELECT * FROM patients p \r\n"
//			+ "//	WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%')) \r\n"
//			+ "//	OR LOWER(p.otherField) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%'))",nativeQuery = true)
////	SELECT * FROM patients p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%')) OR LOWER(p.otherField) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%'));
//
//	 Page<Patient> findBySearch(@Param("search") String search, PageRequest of);

	@Query(value = "SELECT * FROM patients p " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%')) " +
            "OR LOWER(p.patientid) LIKE LOWER(CONCAT('%', CAST(:search AS VARCHAR), '%'))", nativeQuery = true)
    Page<Patient> findBySearch(@Param("search") String search, PageRequest of);

	
//	@Query(value="SELECT * FROM patients WHERE externalref = :externalref AND tenantid = :tenantid", nativeQuery=true)
//	Patient findPatientByTenantidAndExternalref1(@Param("tenantid") String tenantid, @Param("externalref") String externalref);
}




