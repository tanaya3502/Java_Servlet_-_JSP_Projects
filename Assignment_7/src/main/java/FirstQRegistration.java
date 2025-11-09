

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
 * Servlet implementation class FirstQRegistration
 */
@WebServlet("/FirstQRegistration")
public class FirstQRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstQRegistration() {
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
		
		if (isValidInput(name, pass, email, contact)) 
		{
		try {
		     	Class.forName("com.mysql.jdbc.Driver");
		     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
		     	
		     	// Check if the email already exists in the database
		     	if (!isEmailAlreadyExists(con, email)) {
		     		PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?)");
		     		ps.setString(1, name);
		     		ps.setString(2, pass);
		     		ps.setString(3, email);
		     		ps.setString(4, contact);

		     		int i = ps.executeUpdate();
		     		if (i > 0)
		     		{
		     			out.print("<center> <h1>You are successfully registered...</h1>");
		     			out.println("<a href=FirstQLogin.html>Login Here</a> </center>");
		     		} 	
		        } 
		     	else 
		     	{
		     		out.print("<h1>Email already exists. Please use a different email.</h1>");
		        }
			}
			catch(Exception e)
			{
				out.println(e);
				e.printStackTrace();
			}
		}
		else 
		{
			out.print("<h1>Invalid inputs. Please check your data.</h1>");
		}
	}
	private boolean isValidInput(String username, String password, String email, String contact) 
	{
        // Username should be alphabets only
        if (!username.matches("^[a-zA-Z]+$")) {
        	//request.setAttribute("usernameError", "Username should contain only alphabets.");
        	return false;
        }

        // Password should be 6 alphabets and one special character
        if (!password.matches("^(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{6,}$")) {
        	//request.setAttribute("passwordError", "Password should be 6 characters or more and contain at least one special character.");
        	return false;
        }

        // Email validation with @ symbol
        if (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
        	//request.setAttribute("emailError", "Invalid email format.");
        	return false;
        }

        // Contact number should be Indian and 10 digits only
        if (!contact.matches("^[0-9]{10}$")) {
        	//request.setAttribute("contactError", "Contact number should be 10 digits.");
        	return false;
        }

        return true;
    }
	private boolean isEmailAlreadyExists(Connection con, String email) 
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT email FROM login WHERE email = ?");
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