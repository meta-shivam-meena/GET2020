package com.metacube.eadSession4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.eadSession4.model.ParkingPass;
import com.metacube.eadSession4.service.EmployeeService;

@WebServlet("/SelectPass")
public class SelectPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String passType = request.getParameter("passType");
		String vehicleNumber = request.getParameter("vehicleNumber");

		ParkingPass pass = new ParkingPass();

		pass.setPassType(passType);
		pass.setVehicleNumber(vehicleNumber);

		EmployeeService employeeService = EmployeeService.getEmployeeService();
		boolean result = employeeService.registerParkingPass(pass);

		if (result) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Home");
			dispatcher.forward(request, response);
		} else {
			request.getSession().invalidate();
			response.sendRedirect("error.jsp?Error+Selecting+Pass");
		}
	}
}
