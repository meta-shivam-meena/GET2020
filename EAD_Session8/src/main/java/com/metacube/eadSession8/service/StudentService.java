package com.metacube.eadSession8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.eadSession8.dao.StudentDao;
import com.metacube.eadSession8.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
}
