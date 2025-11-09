

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
 * Servlet implementation class FirstQLogin
 */
@WebServlet("/FirstQLogin")
public class FirstQLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstQLogin() {
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
		
		//out.println("<h3> Welcome" + name + "</h3>" );

		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6","root","Tanaya@3502");
		
		PreparedStatement ps = con.prepareStatement("select * from login where name = ? and password = ?");
		ps.setString(1, name);
		ps.setString(2, pass);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) 
		{
			//Login Successful
			response.sendRedirect("FirstQLoginSuccessful.html");
		}
		else 
		{
			//out.println("Login Failed...!");
			response.sendRedirect("FirstQLogin.html");
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