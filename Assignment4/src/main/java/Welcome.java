

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
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
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
				
		if(username.equals("Tanaya") && password.equals("Tanaya")) {
			
			out.println("<html>");
			out.println("<head><title>Login</title></head>");
			out.println("<body><center>");
        	out.println("<h1>Hi "+username+", Login Successful.</h1>");
        	HttpSession session=request.getSession(true);
			out.println("<h1>Your Session ID = "+session.getId()+"</h1>");
			out.println("<form action=\"Logout\" method=\"POST\">");
			out.println("<input type=\"submit\" class=\"button1\" value=\"LogOut\">");
			out.println("</form>");
			out.println("</center></body></html>");	
			//response.sendRedirect("Login.java");
        }
        else {
        	response.sendRedirect("Login.html");
        	out.println("<h1>Please Enter Valid Credentials</h1>");
        }
	}

}
