package com.metacube.eadSession8.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Student {
		
	@NotEmpty
	private String firstName;
	
	private String lastName;
	
	private String fatherName;
	
	@NotEmpty
	private String email;
	
	private int class1;
	
	private int age;
	
	public Student() {}
	
	public Student(String firstName, String lastName, String fatherName,
			String email, int class1, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.class1 = class1;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getClass1() {
		return class1;
	}
	
	public void setClass1(int class1) {
		this.class1 = class1;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}	
}
