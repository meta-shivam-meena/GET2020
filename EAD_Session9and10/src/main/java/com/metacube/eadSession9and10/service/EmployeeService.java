package com.metacube.eadSession9and10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.eadSession9and10.dao.EmoloyeeDao;
import com.metacube.eadSession9and10.model.Employee;
import com.metacube.eadSession9and10.model.ParkingPass;
import com.metacube.eadSession9and10.model.Vehicle;

@Service
public class EmployeeService {
	
	@Autowired
	private EmoloyeeDao employeeDao;
	
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
