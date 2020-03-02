package com.metacube.eadSession9and10.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.eadSession9and10.model.Employee;
import com.metacube.eadSession9and10.model.LoginData;
import com.metacube.eadSession9and10.model.ParkingPass;
import com.metacube.eadSession9and10.model.Vehicle;
import com.metacube.eadSession9and10.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@PostMapping("/Friends")
	public String getFriends(HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		String email = employee.getEmail();
		List<Employee> friends = employeeService.getFriends(email);
		session.setAttribute("friends", friends);
		return "friends";
	}
	
	@PostMapping("/RegisterEmployee")
	public String registerEmployee(Employee employee, HttpSession session) {
		boolean result = employeeService.registerEmployee(employee);
		if (result) {
			employee = employeeService.getEmployee(employee.getEmail());
			session.setAttribute("employee", employee);
			return "registerVehicle";
		} else {
			return "redirect: index";
		}
	}
	
	@PostMapping("/RegisterVehicle")
	public String registerVehicle(Vehicle vehicle, HttpSession session) {
		boolean result = employeeService.registerVehicle(vehicle);
		session.setAttribute("vehicleNumber", vehicle.getVehicleNumber());
		if (result) {
			return "selectPass";
		} else {
			return "redirect: error.jsp?message=Error+registering+vehicle";
		}
	}
	
	@PostMapping("/SelectPass")
	public String selectPass(ParkingPass pass) {
		boolean result = employeeService.registerParkingPass(pass);
		return "employeeHome";
	}
	
	@PostMapping("/Home")
	public String getEmployeeHome() {
		return "employeeHome";
	}
	
	@GetMapping("/Login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/Login")
	public String login(LoginData loginData, HttpSession session) {
		String email = loginData.getEmail();
		String password = loginData.getPassword();
		boolean validUser = employeeService.authenticateEmployee(email, password);
		if (validUser) {
			Employee employee = employeeService.getEmployee(email);
			session.setAttribute("employee", employee);
			return "employeeHome";
		} else {
			return "/";
		}
	}
	
	@PostMapping("/ViewProfile")
	public String viewProfile(String email, Model model, HttpSession session) {
		Employee friend = employeeService.getEmployee(email);
		session.setAttribute("friend", friend);
		return "viewProfile";
	}
	
	@PostMapping("/Logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
