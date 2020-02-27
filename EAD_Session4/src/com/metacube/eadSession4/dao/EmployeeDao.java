package com.metacube.eadSession4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.eadSession4.model.Employee;
import com.metacube.eadSession4.model.ParkingPass;
import com.metacube.eadSession4.model.Vehicle;
import com.metacube.eadSession4.util.DBConnection;

public class EmployeeDao {
	private static EmployeeDao employeeDao;

	private EmployeeDao() {
	}

	public static EmployeeDao getEmployeeDao() {
		if (employeeDao == null) {
			employeeDao = new EmployeeDao();
		}
		return employeeDao;
	}

	public int addEmployee(Employee employee) {
		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String email = employee.getEmail();
		String password = employee.getPassword();
		String contactNumber = employee.getContactNumber();
		String organization = employee.getOrganization();
		int registrationId = employee.getRegistrationId();

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "INSERT INTO employees(fullName, gender, email, password, contactNumber, organization, registrationId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, fullName);
			stmt.setString(2, gender);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setString(5, contactNumber);
			stmt.setString(6, organization);
			stmt.setInt(7, registrationId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Employee getEmployee(String email) {
		Employee employee = null;

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "SELECT * FROM employees WHERE email=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String password = rs.getString("password");
				String contactNumber = rs.getString("contactNumber");
				String organization = rs.getString("organization");
				int registrationId = rs.getInt("registrationId");

				employee = new Employee();

				employee.setFullName(fullName);
				employee.setGender(gender);
				employee.setEmail(email);
				employee.setPassword(password);
				employee.setContactNumber(contactNumber);
				employee.setOrganization(organization);
				employee.setRegistrationId(registrationId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> getEmployeeByOrganization(String organization) {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "SELECT * FROM employees WHERE organization=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, organization);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();

				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String password = "***";
				String contactNumber = rs.getString("contactNumber");
				int registrationId = rs.getInt("registrationId");

				employee = new Employee();

				employee.setFullName(fullName);
				employee.setGender(gender);
				employee.setEmail(email);
				employee.setPassword(password);
				employee.setContactNumber(contactNumber);
				employee.setOrganization(organization);
				employee.setRegistrationId(registrationId);

				employees.add(employee);
				System.out.println(employees.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public int addVehicle(Vehicle vehicle) {
		String name = vehicle.getName();
		String type = vehicle.getType();
		String vehicleNumber = vehicle.getVehicleNumber();
		int employeeId = vehicle.getEmployeeId();
		String identification = vehicle.getIdentification();

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "INSERT INTO vehicles(name, type, vehicleNumber, employeeId, identification) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, vehicleNumber);
			stmt.setInt(4, employeeId);
			stmt.setString(5, identification);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int addParkingPass(ParkingPass parkingPass) {
		String passType = parkingPass.getPassType();
		String vehicleNumber = parkingPass.getVehicleNumber();

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "INSERT INTO parkingPass(passType, vehicleNumber) VALUES(?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, passType);
			stmt.setString(2, vehicleNumber);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
