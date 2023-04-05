package com.crudoperationRestApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String tenantid;
	private String patientid;
	private String externalref;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(long id, String name, String tenantid, String patientid, String externalref) {
		super();
		this.id = id;
		this.name = name;
		this.tenantid = tenantid;
		this.patientid = patientid;
		this.externalref = externalref;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTenantid() {
		return tenantid;
	}
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getExternalref() {
		return externalref;
	}
	public void setExternalref(String externalref) {
		this.externalref = externalref;
	}
	
	
	
	
	
	
	
	

}
