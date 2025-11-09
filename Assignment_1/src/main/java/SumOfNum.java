

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumOfNum
 */
@WebServlet("/SumOfNum")
public class SumOfNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumOfNum() {
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

        // Reading the input parameters
        String num1st = request.getParameter("no1");
        String num2nd = request.getParameter("no2");

        // Converting parameters to integers
        int num1 = Integer.parseInt(num1st);
        int num2 = Integer.parseInt(num2nd);

        // Calculating the sum
        int sum = num1 + num2;

        // Displaying the result
        out.println("<html>");
        out.println("<head><title>Sum Servlet</title></head>");
        out.println("<center>");
        out.println("<body>");
        
        out.println("<h1>Sum of " + num1 + " and " + num2 + " is: " + sum + "</h1>");
      
        out.println("</body>");
        out.println("</center>");
        out.println("</html>");

        out.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
