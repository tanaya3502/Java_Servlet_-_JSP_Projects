import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SixQArithmeticOp
 */
@WebServlet("/SixQArithmeticOp")
public class SixQArithmeticOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SixQArithmeticOp() {
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
      
      try 
      { 
    	  	 int No1 = Integer.parseInt(request.getParameter("no1"));
             int No2 = Integer.parseInt(request.getParameter("no2"));
             String operation[] = request.getParameterValues("operation");
             int result = 0;

             	
             
            if(operation!=null && operation.length!=0)
             {			
            	 for(int i=0; i<operation.length;i++)
				 {
            		 out.println("<h1>Selected Operation is : "+operation[i]+"</h1><br>");
            		 if(operation[i].equals("Addition"))
					{
            			 result = No1 + No2;
            			 out.println("<h2>Addition is</h2>");
					}
            		 if(operation[i].equals("Subtraction"))
            		 {
            			 result = No1 - No2;
            			 out.println("<h2>Substraction is</h2>");
            		 }
            		 if(operation[i].equals("Multiplication"))
            		 {
            			 result = No1 * No2;
            			 out.println("<h2>Multiplication is<h2>");
            		 }
            		 if(operation[i].equals("Division"))
            		 {	
            			 if (No2 != 0) 
            			 {
            				 result = No1 / No2;
            				 out.println("<h2>Division is</h2>");
            			 } 
            			 else 
            			 {
            				 throw new ArithmeticException("<h3>Division by zero is not allowed.</h3>");
            			 }
            		}
				}
            }
      

     response.getWriter().println("<h1>" + result+"<h1>");
    } 
    catch (NumberFormatException e) 
    {
        response.getWriter().println("<h3>Error: Invalid number format</h3>");
    }
    catch (ArithmeticException e) 
    {
        response.getWriter().println("<h3>Error: "+ e.getMessage()+"</h3>");
    }
}
}

		
       /* try {
            int num1 = Integer.parseInt(request.getParameter("no1"));
            int num2 = Integer.parseInt(request.getParameter("no2"));
            String operation = request.getParameter("operation");
            int result = 0;
            
            switch (operation) {
            case "Addition":
                result = num1 + num2;
                break;
            case "Subtraction":
                result = num1 - num2;
                break;
            case "Multiplication":
                result = num1 * num2;
                break;
            case "Division":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                break;
            default:
                throw new UnsupportedOperationException("Invalid operation.");
        }
        response.getWriter().println("Result: " + result);
    } catch (NumberFormatException e) {
        response.getWriter().println("Error: Invalid number format");
    } catch (ArithmeticException e) {
        response.getWriter().println("Error: " + e.getMessage());
    } catch (UnsupportedOperationException e) {
        response.getWriter().println("Error: " + e.getMessage());
    }
}
}
         */