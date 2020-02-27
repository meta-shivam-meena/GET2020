package com.metacube.eadSession4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "/SessionFilter", urlPatterns = { "/Friends", "/Home",
		"/Logout", "/RegisterVehicle", "/SelectPass", "/ViewProfile",
		"/employeeHome", "/friends.jsp", "/registerVehicle.jsp",
		"/selectPass.jsp", "/viewProfile.jsp" })
public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession(false);

		if (session == null) {
			servletResponse.sendRedirect("index.html");
		} else {
			chain.doFilter(request, response);
		}
	}
}