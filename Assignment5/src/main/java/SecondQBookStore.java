import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondQBookStore
 */
@WebServlet("/SecondQBookStore")
public class SecondQBookStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondQBookStore() {
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
        
		String book[]=request.getParameterValues("book");
	
		if(book!=null && book.length!=0)
		{			
			out.println("<ul>");
			for(int i=0; i<book.length;i++)
			{
				out.println("<li><h1>Selected Subject Name : "+book[i]+"</h1></li><br>");
				if(book[i].equals("Science"))
				{
					out.println("name=Botany &nbsp price=400.00 &nbsp author=B P Pandey <br>");
					out.println("name=Zoology &nbsp price=300.00 &nbsp author=Janaki Lenin <br>");
				}
				else if(book[i].equals("Maths"))
				{
					out.println("name=Algebra &nbsp price=100.00 &nbsp author=Sergei Borzunov <br>");
					out.println("name=Geometry &nbsp price=150.00 &nbsp author=Sergei Kurgalin <br>");
				}
				else if(book[i].equals("Languages"))
				{
					out.println("name=Java &nbsp price=450.00 &nbsp author=Herbert Schildt <br>");
					out.println("name=C &nbsp price=550.00 &nbsp author=Dennis Ritchie <br>");					
					out.println("name=PHP &nbsp price=650.00 &nbsp author=Alan Forbes <br>");
				}
				else if(book[i].equals("Others"))
				{
					out.println("name=Ramayana &nbsp price=700.00 &nbsp author=Valmiki <br>");
					out.println("name=Mahabharat &nbsp price=800.00 &nbsp author=Maharishi Veda Vyasa <br>");
					out.println("name=Bhagavat Gita &nbsp price=900.00 &nbsp author=Maharishi Veda Vyasa <br>");
				}
			}
			 out.println("</ul>");
		}
	}
}

