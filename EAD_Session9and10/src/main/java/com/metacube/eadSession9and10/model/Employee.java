package com.metacube.eadSession9and10.model;

import javax.validation.constraints.NotEmpty;

public class Employee {
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String contactNumber;
	
	@NotEmpty
	private String organization;
	
	private int registrationId;
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public int getRegistrationId() {
		return registrationId;
	}
	
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
}
