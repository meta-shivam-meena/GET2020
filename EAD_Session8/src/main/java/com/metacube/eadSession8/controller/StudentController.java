package com.metacube.eadSession8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.eadSession8.model.Student;
import com.metacube.eadSession8.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Value("${home.message}")
	private String message;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addStudent";
		} else {
			studentService.addStudent(student);
			return "redirect:/students";
		}
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		List<Student> students =studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
}
