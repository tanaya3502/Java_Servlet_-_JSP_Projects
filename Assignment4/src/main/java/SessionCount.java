

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCount
 */
@WebServlet("/SessionCount")
public class SessionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<html><body><center>");
		HttpSession session = request.getSession(true);
		out.println("<br><br>");
		
		if(session.isNew())
		{
			out.println("<h1>Welcome Tanaya<br><br></h1>");
			count=0;
		}
		else
		{
			out.println("<h1>Hello Tanaya<br><br></h1>");
			count++;
		}
		
		out.println("<h1>Session ID :"+session.getId()+"</h1><br><br>");
		out.println("<h1>Number Of visits:" +count+ "</h1>\n");
		
		if(count>=10)
		{
			session.invalidate();
		}
		out.println("</center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
