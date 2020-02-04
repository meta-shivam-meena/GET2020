
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It is used to update a student details.
 * @author Shivam Kumar Meena
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classStudent = request.getParameter("class");
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			out.println("<h1>Edit Student Details</h1>");
			out.println("<table>");
			out.println("<form action=\"UpdateStudent1\">");
			out.println("<tr>");
			out.println("<td>First Name</td>");
			out.println("<td>" + "<input type=\"text\" name=\"firstName\" value=\"" + firstName + "\">" + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Last Name</td>");
			out.println("<td>" + "<input type=\"text\" name=\"lastName\" value=\"" + lastName + "\">" + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Father's Name</td>");
			out.println("<td>" + "<input type=\"text\" name=\"fatherName\" value=\"" + fatherName + "\">" + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td>" + "<input type=\"email\" name=\"email\" value=\"" + email + "\">" + "</td>");
			out.println("<input style=\"display:none\" type=\"email\" name=\"oldEmail\" value=\"" + email + "\">");
			out.println("<tr>");
			out.println("<td>Class</td>");
			out.println("<td>" + "<input type=\"text\" name=\"class\" value=\"" + classStudent + "\">" + "</td>");
			out.println("</tr>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Age</td>");
			out.println("<td>" + "<input type=\"number\" name=\"age\" value=\"" + age + "\">" + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td></td>");
			out.println("<td><input type=\"submit\" value=\"update\"></td>");
			out.println("<tr>");
			out.println("</form>");
			out.println("</table>");
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
