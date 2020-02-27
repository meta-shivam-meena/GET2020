package com.metacube.eadSession4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.eadSession4.model.Employee;
import com.metacube.eadSession4.service.EmployeeService;

@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Employee employee = EmployeeService.getEmployeeService().getEmployee(email);
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewProfile.jsp");
		dispatcher.forward(request, response);
	}
}
