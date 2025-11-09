

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
 * Servlet implementation class FiveQDisplay
 */
@WebServlet("/FiveQDisplay")
public class FiveQDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiveQDisplay() {
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
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6","root","Tanaya@3502");
			
			PreparedStatement ps = con.prepareStatement("select * from web");
			ResultSet rs = ps.executeQuery();
			out.println("<center><h1> Information of User </h1>");
			out.println("<table border='1'>");
	        out.println("<tr><th>Name</th> <th>Password</th> <th>Gender</th> <th>Age</th> <th>Language</th> <th>Message</th></tr>");
			
	        while (rs.next()) {
	        String name = rs.getString("name");
	  		String password = rs.getString("password");
	  		String gender= rs.getString("gender");
	  		String age = rs.getString("age");
	  		String language = rs.getString("language");
	  		String message = rs.getString("message");
	        
	  		out.println("<tr><td>"+name+"</td><td>"+password+"</td><td>"+gender+"</td><td>"+age+"</td><td>"+language+"</td><td>"+message+"</td></tr>");	
			}
	        out.println("</table>");
	        out.println("</center>");
		}
		catch (Exception e2) 
		{
			out.println(e2);
		}
	}
}
