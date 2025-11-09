

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class HttpHeader
 */
@WebServlet("/HttpHeader")
public class HttpHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpHeader() {
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
		PrintWriter out= response.getWriter();
		  out.println("<html>");
		  out.println("<head><title>HTTP Header Information</title></head>>");
		  out.println("<body><center>");
	        out.println("<h1>HTTP Header Information</h1>");
	        out.println("<table border='1'>");
	        out.println("<tr><th>Header Name</th><th>Value</th></tr>");
	        out.println("<tr><td>Host Name</td><td>" + request.getHeader("Host") + "</td></tr>");
	        out.println("<tr><td>Accept</td><td>" + request.getHeader("Accept") + "</td></tr>");
	        out.println("<tr><td>Accept Language</td><td>" + request.getHeader("Accept-Language") + "</td></tr>");
	        out.println("<tr><td>Accept Character Set</td><td>" + request.getHeader("Accept-Charset") + "</td></tr>");
	        out.println("<tr><td>Accept Encoding</td><td>" + request.getHeader("Accept-Encoding") + "</td></tr>");
	        out.println("</table>");
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
