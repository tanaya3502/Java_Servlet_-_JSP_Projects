

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


@WebServlet("/SevenQLoginDB")
public class SevenQLoginDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevenQLoginDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String email= request.getParameter("email");
		String contact = request.getParameter("contact");
		
		out.println("<h3>");
		out.println("User Name:=" + name);
		out.println("<br>" + "</br>");
		out.println("</h3>");

		try {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Tanaya@3502");
		
		PreparedStatement ps = con.prepareStatement("insert into info values(?,?,?,?)");
		
		ps.setString(1, name);
		ps.setString(2, pass);
		ps.setString(3, contact);
		ps.setString(4, email);
		
		int i = ps.executeUpdate();
		if (i > 0)
		out.print("You are successfully registered...");
//		out.println("<hr>" + "</hr>");
		PreparedStatement ps1 = con.prepareStatement("select *from info");
				ResultSet rs = ps1.executeQuery();
				while(rs.next())
				{
					String username = rs.getString(1);
					String password = rs.getString(2);
					String mobileno = rs.getString(3);
					String emailid = rs.getString(4);
					out.println("<hr>" + "</hr>");
					out.println(username);
					out.println("<br>" + "</br>");
					out.println(password);
					out.println("<br>" + "</br>");
					out.println(mobileno);
					out.println("<br>" + "</br>");
					out.println(emailid);
					out.println("<br>" + "</br>");
					out.println("<hr>" + "</hr>");
					}
				}catch (Exception e2) 
				{
					System.out.println(e2);
				}
			}
}