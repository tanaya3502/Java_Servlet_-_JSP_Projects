

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FifthQRedistration")
public class FifthQRedistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FifthQRedistration() {
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
	String name=request.getParameter("name");
	String age=request.getParameter("age");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    Cookie nameCookie = new Cookie("name", name);
    Cookie ageCookie = new Cookie("age", age);
    Cookie phoneCookie = new Cookie("phone", phone);
    Cookie emailCookie = new Cookie("email", email);
    
    nameCookie.setMaxAge(120);
    ageCookie.setMaxAge(120);
    phoneCookie.setMaxAge(120);
    emailCookie.setMaxAge(120);
    
    response.addCookie(nameCookie);
    response.addCookie(ageCookie);
    response.addCookie(phoneCookie);
    response.addCookie(emailCookie);

    out.println("<html><body>");
    out.println("<center>");
    out.println("<h1>Login Information </h1>");
    out.println("<h3>My Name is "+name+"</h3>");
    out.println("<h3>I'm "+age+" Years Old</h3>");
    out.println("<h3>My Contact No is "+phone+"</h3>");
    out.println("<h3>My Email ID is "+email+"</h3><br>");
  		
    // Redirect with an explanation after 2 minutes
   response.setHeader("Refresh", "120;url=https://www.google.in");
        
    out.println("<p>Redirecting to www.google.in in 2 minutes...</p>");
    out.println("</center>");
    out.println("</body></html>");
  	}

}
