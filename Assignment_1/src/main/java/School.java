

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class School
 */
@WebServlet("/School")
public class School extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public School() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String college = request.getParameter("college");
		String new_student = request.getParameter("option");
		String major = request.getParameter("major");
		
		String selectedColor = request.getParameter("selectedColor");
		
		String terms = request.getParameter("terms");
		if(terms != null) {
			terms = "yes";
		}
		
		out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("table, th, td {border: 0px;}");
        out.println("body{background-color:"+selectedColor+";}");
        out.println("</style>");
        out.println("<title> Submitted Data </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Submitted Data</h1>");
        out.println("<table>");
        out.println("  <tr>");
        out.println("    <th>Field</th> <th>Value</th>");
        out.println("  </tr>");
        out.println("<tr> <td>Email</td> <td>"+email+"</td> </tr>");
        out.println("<tr> <td>Password</td> <td>"+password+"</td> </tr>");
        out.println("<tr> <td>Birthday</td> <td>"+birthday+"</td> </tr>");
        out.println("<tr> <td>New Student</td> <td>"+new_student+"</td> </tr>");
        out.println("<tr> <td>College</td> <td>"+college+"</td> </tr>");
        out.println("<tr> <td>Major</td> <td>"+major+"</td> </tr>");
        out.println("<tr> <td>Color</td> <td>"+selectedColor+"</td> </tr>");
        out.println("<tr> <td>Terms and Conditions</td> <td>"+terms+"</td> </tr>");
        out.println("</center>");
        out.println("</body>");
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
