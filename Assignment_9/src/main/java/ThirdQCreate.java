

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
 * Servlet implementation class ThirdQCreate
 */
@WebServlet("/ThirdQCreate")
public class ThirdQCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdQCreate() {
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
		     	
		     	PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?)");
		     		ps.setInt(1, no); 
		     		ps.setString(2, name);
			        ps.setDouble(3, price);
		     		
		     		int i = ps.executeUpdate();
		     		if (i > 0)
		     		{
		     			out.print("<center> <h1>Book is Successfully Added...</h1>");
		     		} 	
		     		else 
		    		{
		    			out.print("<h1>Invalid inputs. Please check your data.</h1>");
		    		}
		      } 
		catch(Exception e)
		{
				out.println(e);
				e.printStackTrace();
		}
	}
}
