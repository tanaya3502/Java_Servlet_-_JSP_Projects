import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class FirstQCookies
 */
@WebServlet("/FirstQCookies")
public class FirstQCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstQCookies() {
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

        Cookie usernameCookie = new Cookie("username", "Tanaya");
        Cookie ageCookie = new Cookie("age", "21");

        usernameCookie.setMaxAge(3600); // 1 hour
        ageCookie.setMaxAge(86400);     // 1 day

        response.addCookie(usernameCookie);
        response.addCookie(ageCookie);

        out.println("<center><h2>");
        out.println("<br><br>Cookies have been set.<br><br>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("Cookies present at the client-side:<br><br>");
            for (Cookie cookie : cookies) {
                out.println("Name: " + cookie.getName() + "<br>");
                out.println("Value: " + cookie.getValue() + "<br>");
                out.println("Max Age: " + cookie.getMaxAge() + " seconds<br><br>");
            }
        } else {
            out.println("No cookies present at the client-side.<br>");
            out.println("</h2></center>");
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
