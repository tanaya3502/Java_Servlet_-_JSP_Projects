

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SixQExamRegistration
 */
@WebServlet("/SixQExamRegistration")
public class SixQExamRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SixQExamRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String email= request.getParameter("email");
		String contact = request.getParameter("contact");
		
		boolean isValid = true;
	  	String nameError = "";
        String passwordError = "";
       
	if (!name.matches("^[a-zA-Z\\s]+$")) {
        nameError = "Username should contain only alphabets.";
        isValid = false;
    }

    if (!pass.matches("^(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{6,}$")) {
        passwordError = "Password should be 6 characters or more and contain at least one special character.";
        isValid = false;
    }
    if (isValid) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6","root","Tanaya@3502");	
		
		if (!isEmailAlreadyExists(con, email)) {
		
		PreparedStatement ps = con.prepareStatement("insert into examdetails values(?,?,?,?)");

		ps.setString(1, name);
		ps.setString(2, pass);
		ps.setString(3, email);
		ps.setString(4, contact);
	
		int i = ps.executeUpdate();
		if (i > 0)
		{
			out.print("You are successfully registered...");
		}
		}
		else 
     	{
     		out.print("<h1>Email already exists. Please use a different email.</h1>");
        }
	}
		catch (Exception e2) 
		{
			out.println(e2);
		}
    } else {
        // Display individual error messages for each field
        out.print("<h1>Validation failed. Please check your data:</h1>");
        out.print("<ul>");
        if (!nameError.isEmpty()) {
            out.print("<li>" + nameError + "</li>");
        }
        if (!passwordError.isEmpty()) {
            out.print("<li>" + passwordError + "</li>");
      
        out.print("</ul>");
    }
  }
 }

private boolean isEmailAlreadyExists(Connection con, String email) 
{
	try 
	{
		PreparedStatement ps = con.prepareStatement("SELECT email FROM examdetails WHERE email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs.next(); // Returns true if the email exists in the database
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		return false; // Assume email does not exist in case of an error
	}
  }
}