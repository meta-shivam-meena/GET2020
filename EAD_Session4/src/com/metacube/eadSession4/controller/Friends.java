package com.metacube.eadSession4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.eadSession4.model.Employee;
import com.metacube.eadSession4.service.EmployeeService;

@WebServlet("/Friends")
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		EmployeeService employeeService = EmployeeService.getEmployeeService();
		List<Employee> friends = employeeService.getFriends(email);
		session.setAttribute("friends", friends);
		RequestDispatcher dispatcher = request.getRequestDispatcher("friends.jsp");
		dispatcher.forward(request, response);
	}
}
