

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class delete_servlet
 */
@WebServlet("/delete_servlet")
public class delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		String url = "jdbc:mysql://localhost:3306/";
		String db = "farmer_details";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "abcdefghijkl";
	    String sqlquery="delete from farmer  where mobile_no=(?) and password=(?) ";
	    PrintWriter out = response.getWriter();
		
	    try{
	    	Class.forName(driver);
	    	Connection con = (Connection) DriverManager.getConnection(url+db, user, pass);
	    	//System.out.println("hell0");
	    	 PreparedStatement st = (PreparedStatement) con.prepareStatement(sqlquery);
	    	 String password=request.getParameter("password");
	    	 String mobile = request.getParameter("mobile_num");
	    	 
	    	 st.setString(1,mobile);
	    	 st.setString(2,password);
	    	 st.executeUpdate();
	    		
	    		 out.println("User Account Successfully Deleted. Thanks for Visiting our Site");
	    		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome_page.html");
			   	  dispatcher.include(request, response);
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    
	}
}