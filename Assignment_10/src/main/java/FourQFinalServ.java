

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourQFinalServ
 */
@WebServlet("/FourQFinalServ")
public class FourQFinalServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FourQFinalServ() {
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
		
		 String salary = request.getParameter("salary");
	     String location = request.getParameter("location");

	        // Retrieve personal information from cookies
	        Cookie[] cookies = request.getCookies();
	        String id = "";
	        String name = "";
	        String address = "";
	        String age = "";
	        String experience = "";
	        String skill = "";
	        
	        for (Cookie cookie : cookies) {
	            switch (cookie.getName()) {
	                case "id":
	                    id = cookie.getValue();
	                    break;
	                case "name":
	                    name = cookie.getValue();
	                    break;
	                case "address":
	                    address = cookie.getValue();
	                    break;
	                case "age":
	                    age = cookie.getValue();
	                    break;
	                case "experience":
	                    experience = cookie.getValue();
	                    break;
	                case "skill":
	                    skill = cookie.getValue();
	                    break;
	            }
	        }
	        
	        // Store all values in the database
	        
	        try {
	            // Replace this with your database connection code
	        	Class.forName("com.mysql.jdbc.Driver");
		     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
		     	
		     	if (!isIDAlreadyExists(con, id)) {
		     	
		     	PreparedStatement ps = con.prepareStatement("insert into screen values(?,?,?,?,?,?,?,?)");
	            ps.setString(1, id);
	            ps.setString(2, name);
	            ps.setString(3, address);
	            ps.setString(4, age);
	            ps.setString(5, experience);
	            ps.setString(6, skill);
	            ps.setString(7, salary);
	            ps.setString(8, location);
	            ps.executeUpdate();
	            
		        
		       // response.getWriter().println("<center><h1>Successfully Inserted</h1></center>");
			
		        	out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<style>\r\n"
					+ "body{\r\n"
					+ "	 background-color: rgb(192, 192, 192);\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<center>\r\n"
					+ "<h1>Successfully Inserted</h1>"
					+ "	<h1><a href=FourQPersonal.html>Home</a></h1>\r\n"
					+ "</center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
	            con.close();
	        } 
		     	
		     	else 
		     	{
		     		out.println("<!DOCTYPE html>\r\n"
							+ "<html>\r\n"
							+ "<head>\r\n"
							+ "<meta charset=\"UTF-8\">\r\n"
							+ "<title>Insert title here</title>\r\n"
							+ "<style>\r\n"
							+ "body{\r\n"
							+ "	 background-color: rgb(192, 192, 192);\r\n"
							+ "}\r\n"
							+ "\r\n"
							+ "</style>\r\n"
							+ "</head>\r\n"
							+ "<body>\r\n"
							+ "<center>\r\n"
							+ "<h1>ID already exists. Please use a different ID.</h1>"
							+ "	<h1><a href=FourQPersonal.html>Home</a></h1>\r\n"
							+ "</center>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n");
		        } 	
		  }
	        catch(Exception e)
	        {
				out.println(e);
				e.printStackTrace();
	        }

	}

	private boolean isIDAlreadyExists(Connection con, String id) {
		// TODO Auto-generated method stub
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT id FROM screen WHERE id = ?");
			ps.setString(1, id);
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
	
