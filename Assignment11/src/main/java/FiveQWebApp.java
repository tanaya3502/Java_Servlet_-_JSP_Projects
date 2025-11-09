

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiveQWebApp
 */
@WebServlet("/FiveQWebApp")
public class FiveQWebApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiveQWebApp() {
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
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gender= request.getParameter("rd");
		String age = request.getParameter("age");
		String language = request.getParameter("ch");
		String message = request.getParameter("message");
		
		out.println("<h3>");
		out.println("User Name=" + name+"<br>Password="+password+"<br>Gender="+gender+"<br>Age="+age+"<br>Language="+language+"<br>Message="+message);
		out.println("</h3>");
		
		boolean isValid = true;
		  	String nameError = "";
	        String passwordError = "";
	        String ageError = "";
	        String languageError = "";
	        String messageError = "";

		if (!name.matches("^[a-zA-Z\\s]+$")) {
            nameError = "Username should contain only alphabets.";
            isValid = false;
        }

        if (!password.matches("^(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{6,}$")) {
            passwordError = "Password should be 6 characters or more and contain at least one special character.";
            isValid = false;
        }

        try {
            int ageValue = Integer.parseInt(age);
            if (ageValue >= 30) {
                ageError = "Age should be less than 30.";
                isValid = false;
            }
        } catch (NumberFormatException e) {
            ageError = "Age should be a valid number.";
            isValid = false;
        }

        if (!language.matches("^[a-zA-Z]+$")) {
            languageError = "Language should contain only alphabets.";
            isValid = false;
        }

        if (!message.matches("^[a-zA-Z\\s]+$")) {
            messageError = "Message should contain only alphabets.";
            isValid = false;
        }

        if (isValid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6","root","Tanaya@3502");	
			PreparedStatement ps = con.prepareStatement("insert into web values(?,?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, gender);
			ps.setString(4, age);
			ps.setString(5, language);
			ps.setString(6, message);
			
			int i = ps.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered...");
			}
			catch (Exception e2) 
			{
				out.println(e2);
			}
        } else {
            // Display individual error messages for each field
            out.print("<h1>Validation failed. Please check your data:</h1>");
            out.print("<ul>");
            if (!nameError.isEmpty()) {
                out.print("<li>" + nameError + "</li>");
            }
            if (!passwordError.isEmpty()) {
                out.print("<li>" + passwordError + "</li>");
            }
            if (!ageError.isEmpty()) {
                out.print("<li>" + ageError + "</li>");
            }
            if (!languageError.isEmpty()) {
                out.print("<li>" + languageError + "</li>");
            }
            if (!messageError.isEmpty()) {
                out.print("<li>" + messageError + "</li>");
            }
            out.print("</ul>");
        }
    }
}