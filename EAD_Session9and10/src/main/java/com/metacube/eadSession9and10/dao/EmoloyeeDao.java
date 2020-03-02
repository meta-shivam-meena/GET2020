package com.metacube.eadSession9and10.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.metacube.eadSession9and10.model.Employee;
import com.metacube.eadSession9and10.model.ParkingPass;
import com.metacube.eadSession9and10.model.Vehicle;

@Repository
public class EmoloyeeDao {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addEmployee(Employee employee) {
		String sql = "INSERT INTO employees(fullName, gender, email, password, contactNumber, organization) VALUES(?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, employee.getFullName(), employee.getGender(), employee.getEmail(), employee.getPassword(), employee.getContactNumber(), employee.getOrganization());
	}

	public Employee getEmployee(String email) {
		String sql = "SELECT * FROM employees WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {email}, new EmployeeRowMapper());
	}

	public List<Employee> getEmployeeByOrganization(String organization) {
		String sql = "SELECT * FROM employees WHERE organization=?";
//		return jdbcTemplate.queryForList(sql, new Object[] {organization}, Employee.class);
		
		return jdbcTemplate.query(sql, new Object[] {organization}, new EmployeeRowMapper());
	}

	public int addVehicle(Vehicle vehicle) {
		String sql = "INSERT INTO vehicles(name, type, vehicleNumber, employeeId, identification) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, vehicle.getName(), vehicle.getType(), vehicle.getVehicleNumber(), vehicle.getEmployeeId(), vehicle.getIdentification());
	}

	public int addParkingPass(ParkingPass pass) {
		String sql = "INSERT INTO parkingPass(passType, vehicleNumber) VALUES(?, ?)";
		return jdbcTemplate.update(sql, pass.getPassType(), pass.getPassNumber());
	}
	
	private List<Object> extractVehicleData(Vehicle vehicle) {
		List<Object> data = new ArrayList<Object>();
		data.add(vehicle.getName());
		data.add(vehicle.getType());
		data.add(vehicle.getVehicleNumber());
		data.add(vehicle.getEmployeeId());
		data.add(vehicle.getIdentification());
		return data;
	}
	
	class EmployeeRowMapper implements RowMapper<Employee> {
		
		public Employee mapRow(ResultSet rs, int line) throws SQLException {
			EmployeeResultSetExtractor extractor = new EmployeeResultSetExtractor();
			return extractor.extractData(rs);
		}
	}
	
	final class EmployeeResultSetExtractor implements ResultSetExtractor<Employee> {
		
		public Employee extractData(ResultSet rs) throws SQLException {
			Employee employee = new Employee();
			employee.setFullName(rs.getString("fullName"));
			employee.setGender(rs.getString("gender"));
			employee.setEmail(rs.getString("email"));
			employee.setPassword(rs.getString("password"));
			employee.setContactNumber(rs.getString("contactNumber"));
			employee.setOrganization(rs.getString("organization"));
			employee.setRegistrationId(rs.getInt("registrationId"));
			return employee;
		}
	}

}
