
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It issues the update query on given email and new details of student.
 * @author Shivam Kumar Meena
 */
@WebServlet("/UpdateStudent1")
public class UpdateStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String oldEmail = request.getParameter("oldEmail");
		String classStudent = request.getParameter("class");
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user,
					password);
			String sql = "UPDATE StudentDetails SET firstName=?, lastName=?, fatherName=?, email=?, class=?, age=? WHERE email=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, fatherName);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, classStudent);
			preparedStatement.setInt(6, age);
			preparedStatement.setString(7, oldEmail);

			int status = preparedStatement.executeUpdate();
			if (status == 0) {
				out.println("Failure");
			} else {
				out.println("Success");
			}
			
			preparedStatement.close();
			connection.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
