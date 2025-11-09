import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ThirdQVoter
 */
@WebServlet("/ThirdQVoter")
public class ThirdQVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdQVoter() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<center>");		
		String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        String message;
        if (age >= 18) {
            message = "Hello " + name + ", you are eligible for voting.";
        } else {
            message = "Hello " + name + ", you are not eligible for voting.";
        }
        out.println("<html><body>");
        out.println("<h1>Voting Eligibility Result</h1>");
        out.println("<h2><p>" + message + "</p></h2>");
        out.println("</center>");
        out.println("</body></html>");
	}
}
