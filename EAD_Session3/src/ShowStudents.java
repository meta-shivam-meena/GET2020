import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * It is used to show details of all students stored in the database.
 * @author Shivam Kumar Meena
 */
@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user,
					password);
			String sql = "SELECT * FROM StudentDetails";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			out.println("<head>");
			out.println("<style>");
			out.println("table, th, td{border: 1px solid black; margin: 2px; padding:2px}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>All Student Details</h1>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Father's Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Age</th>");
			out.println("<th>Class</th>");
			out.println("<th>Update</th>");
			out.println("</tr>");
			out.println();
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String classStudent = resultSet.getString("class");
				int age = resultSet.getInt("age");

				out.println("<tr>");
				out.println("<td>" + firstName + "</td>");
				out.println("<td>" + lastName + "</td>");
				out.println("<td>" + fatherName + "</td>");
				out.println("<td>" + email + "</td>");
				out.println("<td>" + age + "</td>");
				out.println("<td>" + classStudent + "</td>");
				out.println("<td><a href=\"UpdateStudent?firstName="
						+ firstName + "&lastName=" + lastName + "&fatherName="
						+ fatherName + "&email=" + email + "&class="
						+ classStudent + "&age=" + age + "\">update</a></td>");
				out.println("</tr>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			
			statement.close();
			connection.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
