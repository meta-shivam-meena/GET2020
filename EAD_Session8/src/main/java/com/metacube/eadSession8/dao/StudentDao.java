package com.metacube.eadSession8.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.eadSession8.model.Student;

@Repository
public class StudentDao {
	private List<Student> students = new ArrayList<Student>() {
		
		private static final long serialVersionUID = 1L;

		{
			add(new Student("Shivam", "Meena", "Father", "shivam@shivam.com", 10, 10));
			add(new Student("Shikher", "Jain", "Father", "shikher@shikher.com", 12, 12));
			add(new Student("Tanmay", "Mathur", "Father", "tanmay@tanmay.com", 8, 8));
			add(new Student("Lovendra", "Shekhawat", "Father", "lovendra@lovendra.com", 9, 9));
		}
	};
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public Student getStudent(String email) {
		for (Student student: students) {
			if (student.getEmail().equals(email)) {
				return student;
			}
		}
		
		return null;
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
	
}
