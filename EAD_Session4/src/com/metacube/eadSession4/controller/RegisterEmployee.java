package com.metacube.eadSession4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.eadSession4.model.Employee;
import com.metacube.eadSession4.service.EmployeeService;

@WebServlet(description = "Employee Registration", urlPatterns = { "/RegisterEmployee" })
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if (!password.equals(confirmPassword)) {
			response.sendRedirect("error.jsp?message=Passwords+don't+match");
			return;
		}
		
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("contactNumber");
		String organization = request.getParameter("organization");

		Employee employee = new Employee();
		employee.setFullName(fullName);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setContactNumber(contactNumber);
		employee.setOrganization(organization);

		EmployeeService employeeService = EmployeeService.getEmployeeService();
		boolean registered = employeeService.registerEmployee(employee);
		if (registered) {
			employee = employeeService.getEmployee(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("employee", employee);
			session.setAttribute("email", email);
			request.setAttribute("registrationId", employee.getRegistrationId());
			System.out.println(employee.getRegistrationId() + "registrationId");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("registerVehicle.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			response.sendRedirect("error.jsp?message=Error+registering+employee");
			return;
		}
	}
}
