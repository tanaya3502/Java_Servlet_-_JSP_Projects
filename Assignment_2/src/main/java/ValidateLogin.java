

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLogin() {
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
		
		String fn = request.getParameter("fn");
		String mn = request.getParameter("mn");
		String ln = request.getParameter("ln");
		String user = request.getParameter("user");
		String passw = request.getParameter("passw");
		String conpass = request.getParameter("conpass");
		String locate = request.getParameter("locate");
		String edu = request.getParameter("edu");
		String contact = request.getParameter("cont"); 
		
		boolean isValid = true;
        String errorMessage = " ";
        
   if (isEmpty(fn) || isEmpty(ln) || isEmpty(user) || isEmpty(passw) || isEmpty(conpass)) {
            isValid = false;
            errorMessage += "Required fields must not be empty.<br>";
   }
   else {
        
        if (!isValidName(fn) || !isValidName(ln)) {
            isValid = false;
            errorMessage += "Name fields should contain only alphabets.<br>";
        }
        
        if(!isEmpty(mn)) {
        	if(!isValidName(mn)) {
        		 isValid = false;
                 errorMessage += "Name fields should contain only alphabets.<br>";
        	}
        }
        
        if(!isEmpty(contact)) {
        	if(!isValidMobileNumber(contact)) {
        		isValid = false;
                errorMessage += "Please enter valid mobile number<br>";
        	}
        }

        // Check password restrictions
        if (!isValidPassword(passw)) {
            isValid = false;
            errorMessage += "Passwords should contain alphabets, at least one number and special character, and be at least 6 characters long.<br>";
        } else if (!passw.equals(conpass)) {
            isValid = false;
            errorMessage += "Passwords do not match.<br>";
        }
    }

        // Display response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");

        if (isValid) {
            out.println("<h1>Registration Successful</h1>");
            out.println("<h1>Thank you for registering!</h1>");
        } else {
            out.println("<h1>Registration Failed</h1>");
            out.println("<h1>Error(s) occurred:</h1>");
            out.println("<h1>" + errorMessage + "</h1>");
        }

        out.println("</center></body></html>");
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidName(String name) {
        return name.matches("^[A-Za-z]+$");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.[A-Za-z])(?=.*[0-9])(?=.*[@#$%^&+=]).{6,}$");
    }
    
    private boolean isValidMobileNumber(String mobile) {
        return mobile.matches("^[6-9]\\d{9}$");
    }

	}
