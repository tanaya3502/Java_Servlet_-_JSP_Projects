import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourthQServer
 */
@WebServlet("/FourthQServer")
public class FourthQServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FourthQServer() {
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
		String selectedSubject = request.getParameter("option");
	     Cookie[] cookies = request.getCookies();
	     boolean cookieExists = false;
	        
	     response.setContentType("text/html");
	     PrintWriter out = response.getWriter();

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	            	 if (cookie.getName().equals("selectedSubject")) {
	                     cookieExists = true;
	                     break;
	            	 }
	            }
	        }
	
	        if (!cookieExists) {
	            Cookie subjectCookie = new Cookie("selectedSubject", selectedSubject);
	            subjectCookie.setMaxAge(365 * 24 * 60 * 60); // Set the cookie to expire in 1 year
	            response.addCookie(subjectCookie);
	        }
	        out.println("<html><head><title>Subject Selected</title></head><body><center>");
	        out.println("<h1>Selected Subject: " + selectedSubject + "</h1>");
	        out.println("<button><a href='FourthQServer.html'>Go back</a></button>");
	        out.println("</center></body></html>");
	}

}
