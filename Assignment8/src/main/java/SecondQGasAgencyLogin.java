

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondQGasAgencyLogin
 */
@WebServlet("/SecondQGasAgencyLogin")
public class SecondQGasAgencyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondQGasAgencyLogin() {
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

		String agency = request.getParameter("agencyid");
		String password = request.getParameter("password");

		if(agency.equals("Admin@123") && password.equals("Admin@123")) {
			// Login successful
			out.println("<h1>Hi.... Login Successful...</h1>");
	    	response.sendRedirect("SecondQGasAgencyBooking.java");	           
		}
		else {
				// Login failed
				out.println("<h1>Login Failed</h1>");
				response.sendRedirect("SecondQMainPage.html");
		}

	}
}	