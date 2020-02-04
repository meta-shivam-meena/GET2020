
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It is used to search a student with First name, Last name and class.
 * @author Shivam Kumar Meena
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");

		String firstName = request.getParameter("firstName");
		if ("".equals(firstName)) {
			firstName = "%";
		}
		String lastName = request.getParameter("lastName");
		if ("".equals(lastName)) {
			lastName = "%";
		}
		String classStudent = request.getParameter("class");
		if ("".equals(classStudent)) {
			classStudent = "%";
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user,
					password);
			String sql = "SELECT * FROM StudentDetails WHERE firstName LIKE '"
					+ firstName + "' AND lastName LIKE '" + lastName
					+ "' AND class LIKE '" + classStudent + "'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			out.println("<head>");
			out.println("<style>");
			out.println("table, th, td{border: 1px solid black; margin: 2px; padding:2px}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Search Results</h1>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>First Name</td>");
			out.println("<td>Last Name</td>");
			out.println("<td>Father's Name</td>");
			out.println("<td>Email</td>");
			out.println("<td>Age</td>");
			out.println("<td>Class</td>");
			out.println("</tr>");
			out.println();
			while (resultSet.next()) {
				firstName = resultSet.getString("firstName");
				lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				classStudent = resultSet.getString("class");
				int age = resultSet.getInt("age");

				out.println("<tr>");
				out.println("<td>" + firstName + "</td>");
				out.println("<td>" + lastName + "</td>");
				out.println("<td>" + fatherName + "</td>");
				out.println("<td>" + email + "</td>");
				out.println("<td>" + age + "</td>");
				out.println("<td>" + classStudent + "</td>");
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
