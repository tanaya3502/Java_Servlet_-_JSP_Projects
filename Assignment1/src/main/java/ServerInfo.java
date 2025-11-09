

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerInfo
 */
@WebServlet("/ServerInfo")
public class ServerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerInfo() {
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
        
        out.println("<html>");
        out.println("<head><title>Server Information</title></head>");
        out.println("<center>");
        out.println("<body>");
        out.println("<h1>Server Information</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Property</th> <th>Value</th></tr>");
        
        out.println("<tr><td>Server Name</td><td>" + request.getServerName() + "</td></tr>");
        out.println("<tr><td>Server Port</td><td>" + request.getServerPort() + "</td></tr>");
        out.println("<tr><td>Servlet Name</td><td>" + getServletName() + "</td></tr>");
        out.println("<tr><td>Servlet Context Path</td><td>" + request.getContextPath() + "</td></tr>");
        out.println("<tr><td>Servlet API Version</td><td>" + getServletContext().getMajorVersion() + "." +
                getServletContext().getMinorVersion() + "</td></tr>");
        
        out.println("</table>");
        out.println("</body>");
        out.println("</center>");
        out.println("</html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
