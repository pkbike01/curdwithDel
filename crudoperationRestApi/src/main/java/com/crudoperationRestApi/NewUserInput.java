package com.crudoperationRestApi;

import java.util.List;

public class NewUserInput {
	
	List<User> users;
	List<Patient> patients;
	public NewUserInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewUserInput(List<User> users, List<Patient> patients) {
		super();
		this.users = users;
		this.patients = patients;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	

}
