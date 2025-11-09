

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
 * Servlet implementation class ElevelQDisplayInfo
 */
@WebServlet("/ElevelQDisplayInfo")
public class ElevelQDisplayInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElevelQDisplayInfo() {
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
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gender= request.getParameter("rd");
		String age = request.getParameter("age");
		String language = request.getParameter("ch");
		String message = request.getParameter("message");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<h3>");
		out.println("User Name=" + name+"<br>Password="+password+"<br>Gender="+gender+"<br>Age="+age+"<br>Language="+language+"<br>Message="+message);
		out.println("</h3>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","Tanaya@3502");

			PreparedStatement ps = con.prepareStatement("insert into display values(?,?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, gender);
			ps.setString(4, age);
			ps.setString(5, language);
			ps.setString(6, message);
			
			int i = ps.executeUpdate();
			if (i > 0)
			out.print("You are successfully registered...");
		}
		catch (Exception e2) 
		{
			System.out.println(e2);
		}
	}
}
