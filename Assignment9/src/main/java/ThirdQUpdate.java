

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
 * Servlet implementation class ThirdQUpdate
 */
@WebServlet("/ThirdQUpdate")
public class ThirdQUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdQUpdate() {
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

		Integer no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		
		try {
		     	Class.forName("com.mysql.jdbc.Driver");
		     	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6", "root", "Tanaya@3502");
		     	
		     	PreparedStatement ps = con.prepareStatement("UPDATE book SET bname=?, price=? WHERE bno=?");
		     		 
		     		ps.setString(1, name);
			        ps.setDouble(2, price);
			        ps.setInt(3, no);
		     		
			        int row = ps.executeUpdate();
		            if (row > 0) {
		                out.print("<center><h1>Book is Successfully Updated...</h1></center>");
		            } else {
		                out.print("<center><h1>No records updated. Please check your data.</h1></center>");
		            }
		            
		            con.close();
		}     		
		catch(Exception e)
		{
				out.println(e);
				e.printStackTrace();
		}
	}
}

