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

@WebServlet(description = "Login Servlet", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		EmployeeService employeeService = EmployeeService.getEmployeeService();
		boolean validUser = employeeService.authenticateEmployee(email,
				password);
		if (validUser) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			Employee employee = employeeService.getEmployee(email);
			session.setAttribute("employee", employee);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("employeeHome.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("error.jsp?message=Invalid+email+or+password");
		}
	}
}
