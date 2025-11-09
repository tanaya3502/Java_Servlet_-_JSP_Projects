

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourQSecondServ
 */
@WebServlet("/FourQSecondServ")
public class FourQSecondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FourQSecondServ() {
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
		
		String experience = request.getParameter("experience");
        String skill = request.getParameter("skill");

        // Create cookies for experience and skill
        Cookie experienceCookie = new Cookie("experience", experience);
        Cookie skillCookie = new Cookie("skill", skill);

        // Add cookies to the response
        response.addCookie(experienceCookie);
        response.addCookie(skillCookie);
		
		out.println("<!DOCTYPE html>\r\n"
		+ "<html>\r\n"
		+ "<head>\r\n"
		+ "<meta charset=\"UTF-8\">\r\n"
		+ "<title>Insert title here</title>\r\n"
		+ "<style>\r\n"
		+ ".t1{\r\n"
		+ "  \r\n"
		+ "    justify-content: center;\r\n"
		+ "    align-items: center;\r\n"
		+ "    flex-direction: column;\r\n"
		+ "    border: 2px solid black;\r\n"
		+ "    background-color: grey;\r\n"
		+ "    width: 70vh;  \r\n"
		+ "    margin-top: 10px;\r\n"
		+ "}\r\n"
		+ ".t2{\r\n"
		+ "     margin-top: 10px;\r\n"
		+ "	 padding: 10px 20px;\r\n"
		+ "	 background-color: rgb(192, 192, 192);\r\n"
		+ " 	 border: 10px solid grey;\r\n"
		+ "	 cursor: pointer;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ "</style>\r\n"
		+ "</head>\r\n"
		+ "<body>\r\n"
		+ "<center>\r\n"
		+ "<form action=\"FourQFinalServ\" method=\"POST\">\r\n"
		+ "	<div class=\"t1\">\r\n"
		+ "	\r\n"
		+ "	<div class=\"t2\">\r\n"
		+ "	Enter Expected Salary : <input type=\"number\" name=\"salary\" placeholder=\"Enter Salary\" required>\r\n"
		+ "	</div>\r\n"
		+ "			\r\n"
		+ "	<div class=\"t2\">\r\n"
		+ "	Enter Preffered Location : <input type=\"text\" name=\"location\" placeholder=\"Enter Location\" required>\r\n"
		+ "	</div>\r\n"
		+ "	\r\n"
		+ "	<div class=\"t2\">\r\n"
		+ "	<br><input type=\"submit\" value=\"Submit\"><br><br>\r\n"
		+ "	</div>\r\n"
		+ "	\r\n"
		+ "	</div>\r\n"
		+ "</form>\r\n"
		+ "</center>\r\n"
		+ "</body>\r\n"
		+ "</html>");
	}

}
