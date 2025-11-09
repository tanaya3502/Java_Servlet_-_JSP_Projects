import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SixQExam
 */
@WebServlet("/SixQExam")
public class SixQExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SixQExam() {
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
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		
		out.println("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<style>\r\n"
				+ "form{\r\n"
				+ "		background:rgb(244, 244, 164);\r\n"
				+ "		width: 50%;\r\n"
				+ "		box-align: center;\r\n"
				+ "		text-align: left;\r\n"
				+ "		border: 2px;\r\n"
				+ "		border: solid rgb(0, 0, 0);\r\n"
				+ "		box-sizing: border-box;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "h1,h3{\r\n"
				+ "	color: red;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<center>\r\n"
				+ "	<form action=\"SixQExamResult\" method=\"post\">\r\n"
				+ "		\r\n"
				+ "	<center><h1>Exam</h1></center>\r\n"
				+ "	<ol type=\"number\" name=\"Question\">\r\n"
				+ "	<li><h3>What is Servlet?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd1\" value=\"Technology\">Technology <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd1\" value=\"Interface\">Interface <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd1\" value=\"Class\">Class <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd1\" value=\"None of These\">None of These<br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which of the following is not HTTP request method?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd2\" value=\"Get\">Get <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd2\" value=\"Put\">Put <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd2\" value=\"Set\">Set <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd2\" value=\"Action\">Action<br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3> Which methods are used to bind the objects on HttpSession instance and get the objects?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd3\" value=\"setAttribute\">setAttribute <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd3\" value=\"getAttribute\">getAttribute <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd3\" value=\"Both A & B\">Both A & B <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd3\" value=\"None of the above\">None of the above<br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which of the following is the correct order of servlet life cycle phase methods?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd4\" value=\"init(), service(), destroy()\">init(), service(), destroy()<br>\r\n"
				+ "	<input type=\"radio\" name=\"rd4\" value=\"initialize(), service(), destroy()\">initialize(), service(), destroy()<br> \r\n"
				+ "	<input type=\"radio\" name=\"rd4\" value=\"init(), execute(), destroy()\">init(), execute(), destroy()<br>\r\n"
				+ "	<input type=\"radio\" name=\"rd4\" value=\"init(), service(), delete()\">init(), service(), delete()<br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which of the following code can be used to redirect user to different url?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd5\" value=\"request.sendRedirect(location)\">request.sendRedirect(location)<br>\r\n"
				+ "	<input type=\"radio\" name=\"rd5\" value=\"response.sendRedirect(location)\">response.sendRedirect(location)<br>\r\n"
				+ "	<input type=\"radio\" name=\"rd5\" value=\"header.sendRedirect(location)\">header.sendRedirect(location)<br>\r\n"
				+ "	<input type=\"radio\" name=\"rd5\" value=\"None of the above\">None of the above<br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which of the following is true about servlet containers?</h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd6\" value=\"They are used to compile servlets into bytecode\">They are used to compile servlets into bytecode <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd6\" value=\"They are responsible for managing the lifecycle of servlets\">They are responsible for managing the lifecycle of servlets <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd6\" value=\"hey are part of the Java Development Kit (JDK)\">They are part of the Java Development Kit (JDK) <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd6\" value=\"They are used for storing servlet-related data\">They are used for storing servlet-related data <br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which of the following is true about servlet threading? </h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd7\" value=\"Each servlet instance runs in a separate thread\">Each servlet instance runs in a separate thread <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd7\" value=\"All servlet instances run in the same thread \">All servlet instances run in the same thread <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd7\" value=\"Servlets do not support multithreading\">Servlets do not support multithreading <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd7\" value=\"Servlets always run in parallel threads\">Servlets always run in parallel threads <br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>How can a servlet send data back to the client? </h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd8\" value=\"By calling the forward() method \">By calling the forward() method <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd8\" value=\"By using the println() method of the PrintWriter class\">By using the println() method of the PrintWriter class <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd8\" value=\"By invoking the getRequestDispatcher() method\">By invoking the getRequestDispatcher() method <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd8\" value=\"By setting response headers \">By setting response headers <br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>Which object is used to obtain initialization parameters in a servlet? </h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd9\" value=\"ServletConfig\">ServletConfig <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd9\" value=\"HttpServletRequest\">HttpServletRequest <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd9\" value=\"HttpServletResponse\">HttpServletResponse <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd9\" value=\"ServletContext\">ServletContext <br><br><br><br>\r\n"
				+ "	\r\n"
				+ "	<li><h3>What is the purpose of the doPost() method in a servlet? </h3></li>\r\n"
				+ "	<input type=\"radio\" name=\"rd10\" value=\"To handle HTTP POST requests\">To handle HTTP POST requests <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd10\" value=\"To initialize the servlet\">To initialize the servlet <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd10\" value=\"To forward the request to another resource \">To handle HTTP GET requests <br>\r\n"
				+ "	<input type=\"radio\" name=\"rd10\" value=\"To forward the request to another resource \">To forward the request to another resource <br><br><br><br>\r\n"
				+ "	</ul>\r\n"
				+ "		\r\n"
				+ "	<input type=\"submit\" value=\"Submit\">\r\n"
				+ "	\r\n"
				+ "	</form>	\r\n"
				+ "	</center>\r\n"
				+ "</body>\r\n"
				+ "</html>");
			
	}
}