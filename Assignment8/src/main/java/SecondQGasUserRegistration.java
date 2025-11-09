

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondQGasUserRegistration
 */
@WebServlet("/SecondQGasUserRegistration")
public class SecondQGasUserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondQGasUserRegistration() {
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
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		out.println("<!DOCTYPE html>\r\n"
		+ "		<html>\r\n"
		+ "\r\n"
		+ "		<head>\r\n"
		+ "		    <title>Gas Booking System</title>\r\n"
		+ "		    <style>\r\n"
		+ "		        body {\r\n"
		+ "		            text-align: center;\r\n"
		+ "		            font-family: Arial, sans-serif;\r\n"
		+ "		            background-color: rgb(113, 113, 113);\r\n"
		+ "		        }\r\n"
		+ "		        header{\r\n"
		+ "		    		background-color: #f9f9f9;\r\n"
		+ "		    		color: rgb(128, 128, 128);\r\n"
		+ "		    		text-align: center; \r\n"
		+ "		    		font-size: 40px; \r\n"
		+ "		    		font-weight: bold; \r\n"
		+ "		    		padding-top:2px ;\r\n"
		+ "		    		padding-bottom: 2px;\r\n"
		+ "		    		border: 2px solid #ccc;\r\n"
		+ "		            border-radius: 5px;\r\n"
		+ "				}\r\n"
		+ "		       form {\r\n"
		+ "		            margin: 20px;\r\n"
		+ "		            padding: 14px;\r\n"
		+ "		            border: 2px solid #ccc;\r\n"
		+ "		            border-radius: 5px;\r\n"
		+ "		            background-color: #f9f9f9;\r\n"
		+ "		            display: inline-block;\r\n"
		+ "		       }\r\n"
		+ " h1{\r\n"
		+ "			color: white;\r\n"
		+ "		}"
		+ "		    </style>\r\n"
		+ "		</head>\r\n"
		+ "\r\n"
		+ "		<body>\r\n"
		+ "		    <center>\r\n"
		+ "			        <header><u>Gas Booking System</u></header>\r\n"
		+ "		    </center>\r\n"
		+ "		</body>\r\n");
		
		 	String username = request.getParameter("username");
	        String userid = request.getParameter("userid");
	        String password = request.getParameter("password");
	        String contact = request.getParameter("contact");
	        String email = request.getParameter("email");
		
	        try {
		     	Class.forName("com.mysql.jdbc.Driver");
		     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
		     	
		     	PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");
		     		ps.setString(1, username);
		     		ps.setString(2, userid);
		     		ps.setString(3, password);
		     		ps.setString(4, email);
		     		ps.setString(5, contact);

		     		int i = ps.executeUpdate();
		     		if (i > 0)
		     		{
		     			out.print("<center> <h1>You are successfully registered...</h1>");
		     			out.print("<h1><a href=\"SecondQMainPage.html\">Login</a></h1>");
		     		} 	
		     		else {
		     			out.print("<center> <h1>Registered Failed...</h1>");
		     		}
		        } 
			
			catch(Exception e)
			{
				out.println("<center> <h1> Use Another User ID<br> User Id is Already Exits<br>"+e+"</center> </h1>");
				e.printStackTrace();
			}
      }
}
