

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
 * Servlet implementation class SecondQGasUserLogin
 */
@WebServlet("/SecondQGasUserLogin")
public class SecondQGasUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondQGasUserLogin() {
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

		
	 	
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        		
        try {
	     	Class.forName("com.mysql.jdbc.Driver");
	     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
	     	
	     	PreparedStatement ps = con.prepareStatement("select * from user where User_ID = ? and Password = ?");
			ps.setString(1, userid);
			ps.setString(2, password);

			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				out.println("<h1>Login Successful</h1>");
				response.sendRedirect("SecondQGasUserBooking.html");
			}
			else 
			{
				out.println("<h1>Login Failed...!</h1>");
				response.sendRedirect("SecondQMainPage.html");
			}
			rs.close();
			ps.close();
			con.close();
			}catch (Exception e2) 
				{
					out.println(e2);
				}
		}
}
