package com.metacube.eadSession4.service;

import java.util.List;

import com.metacube.eadSession4.dao.EmployeeDao;
import com.metacube.eadSession4.model.Employee;
import com.metacube.eadSession4.model.ParkingPass;
import com.metacube.eadSession4.model.Vehicle;

public class EmployeeService {
	private static EmployeeService employeeService;
	
	private EmployeeDao employeeDao;
	
	private EmployeeService() {
		employeeDao = EmployeeDao.getEmployeeDao();
	}
	
	public static EmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	public boolean registerEmployee(Employee employee) {
		int result = employeeDao.addEmployee(employee);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean registerVehicle(Vehicle vehicle) {
		int result = employeeDao.addVehicle(vehicle);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean registerParkingPass(ParkingPass parkingPass) {
		int result = employeeDao.addParkingPass(parkingPass);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Employee getEmployee(String email) {
		return (employeeDao.getEmployee(email));
	}
	
	public List<Employee> getFriends(String email) {
		String organization = getEmployee(email).getOrganization();
		return employeeDao.getEmployeeByOrganization(organization);
	}
	
	public boolean authenticateEmployee(String email, String password) {
		Employee employee = getEmployee(email);
		if (employee == null) {
			return false;
		}
		return getEmployee(email).getPassword().equals(password);
	}
}
