

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SixQExamResult
 */
@WebServlet("/SixQExamResult")
public class SixQExamResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SixQExamResult() {
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
       
        try {
            // Load the database driver and establish a connection
        	  Class.forName("com.mysql.jdbc.Driver");
      		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6","root","Tanaya@3502");
      		
      		int correctCount = 0;
            int wrongCount = 0;

            // Iterate through the questions and check answers
            for (int i = 1; i <= 10; i++) {
                String questionId = Integer.toString(i);
                String selectedAnswer = request.getParameter("rd" + i);

                // Retrieve the correct answer from the database
                PreparedStatement ps = con.prepareStatement("SELECT CorrectAnswer FROM exam_result WHERE QuestionID = ?");
                ps.setString(1, questionId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String correctAnswer = rs.getString("CorrectAnswer");
                    if (correctAnswer.equals(selectedAnswer)) {
                        correctCount++;
                    } else {
                        wrongCount++;
                    }
                }
                rs.close();
                ps.close();
            }

            // Display the result
            out.println("<html><head><title>Result of Online Exam</title><style>\r\n"
            		+ "form{\r\n"
            		+ "		background:rgb(244, 244, 164);\r\n"
            		+ "		width: 50%;\r\n"
            		+ "		box-align: center;\r\n"
            		
            		+ "		border: 2px;\r\n"
            		+ "		border: solid rgb(0, 0, 0);\r\n"
            		+ "		box-sizing: border-box;\r\n"
            		+ "\r\n"
            		+ "}\r\n"
            		+ "h1{\r\n"
            		+ "	color: red;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ "</style></head><body><center><form>");
            out.println("<center><h1>Exam Result</h1><br><br>");
            out.println("<h3>Correct Answers: </h3><br>" + correctCount+"<br><br>");
            out.println("<h3>Wrong Answers: </h3><br>" + wrongCount + "</center><br><br>");
            out.println("</form></center></body></html>");

            // Close the database connection
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
