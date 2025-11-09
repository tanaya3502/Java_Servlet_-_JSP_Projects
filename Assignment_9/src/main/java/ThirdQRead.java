

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
 * Servlet implementation class ThirdQRead
 */
@WebServlet("/ThirdQRead")
public class ThirdQRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdQRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
		     	Class.forName("com.mysql.jdbc.Driver");
		     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
		     	
		     	    PreparedStatement ps = con.prepareStatement("select * from book");
		     		ResultSet rs = ps.executeQuery();
		 	        
		     		out.println("<center><h1> Books Details</h1>");
					out.println("<table border='1'>");
			        out.println("<tr><th>Book No</th> <th>Book Name</th> <th>Book Price</th></tr>");
					
		     		while (rs.next()) {
		 	        String bno = rs.getString("bno");
		 	  		String bname = rs.getString("bname");
		 	  		String bprice= rs.getString("price");
		 	  		out.println("<tr>"
		 	  				+ "<td>"+bno+"</td>"
		 	  				+ "<td>"+bname+"</td>"
		 	  				+ "<td>"+bprice+"</td>"
		 	  				+ "</tr>");	
		 			}
		 	        out.println("</table>");
		 	        out.println("</center>");
		 		}
		       
		catch(Exception e) {
		    out.println("<p>Error: " + e.getMessage() + "</p>");
		    e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
