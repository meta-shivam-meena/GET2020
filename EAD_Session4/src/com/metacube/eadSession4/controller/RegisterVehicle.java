package com.metacube.eadSession4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.eadSession4.model.Vehicle;
import com.metacube.eadSession4.service.EmployeeService;

@WebServlet(description = "Register Vehicle", urlPatterns = { "/RegisterVehicle" })
public class RegisterVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehicleName = request.getParameter("vehicleName");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String identification = request.getParameter("identification");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setName(vehicleName);
		vehicle.setType(vehicleType);
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setIdentification(identification);
		vehicle.setEmployeeId(employeeId);
		
		EmployeeService employeeService = EmployeeService.getEmployeeService();
		boolean result = employeeService.registerVehicle(vehicle);
		
		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("selectPass.jsp");
			dispatcher.forward(request, response);
		} else {
			request.getSession().invalidate();
			response.sendRedirect("error.jsp?message=Error+registering+vehicle");
		}
	}
}
