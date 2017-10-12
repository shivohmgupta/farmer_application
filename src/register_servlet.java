

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;




/**
 * Servlet implementation class register_servlet
 */
@WebServlet("/register_servlet")
public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		//HttpSession session = request.getSession(true);
		String url = "jdbc:mysql://localhost:3306/";
		String db_farmer = "farmer_details";
		String db_customer = "customer_details";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "abcdefghijkl";
	    
	    
	    PrintWriter out = response.getWriter();
	    String choice = request.getParameter("choice");
	    if(choice.equals("farmer"))
	    {
	    try{
	    	Class.forName(driver);
	    	Connection con = (Connection) DriverManager.getConnection(url+db_farmer, user, pass);
	    	//System.out.println("hell0");
	    	String sqlquery="Insert into farmer(first_name,last_name,city,mobile_no,password) values(?,?,?,?,?) ";
	    	 PreparedStatement st = (PreparedStatement) con.prepareStatement(sqlquery);
	    	 //System.out.println("hell012");
	    	 st.setString(1,request.getParameter("firstname"));
	    	 st.setString(2,request.getParameter("lastname"));
	    	 st.setString(3,request.getParameter("city"));
	    	 st.setString(4,request.getParameter("mobile"));
	    	 st.setString(5,request.getParameter("password"));
	    	 //st.executeQuery(sqlquery);
	    	 
		if(st.executeUpdate()>0)
		{
			out.println("Registration Successful. Welcome");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		   	  dispatcher.include(request, response);
		}
		else{
			out.println("Sorry, Unable to Register. Please try after some time");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginjsp");
		   	  dispatcher.include(request, response);
		}
	}catch(Exception ex)
	    {
		ex.printStackTrace();
	    }
}
	
	else if(choice.equals("customer"))
	{
		
		try{
	    	Class.forName(driver);
	    	Connection con = (Connection) DriverManager.getConnection(url+db_customer, user, pass);
	    	//System.out.println("hell0");
	    	String sqlquery="Insert into customer(first_name,last_name,city,mobile_no,password) values(?,?,?,?,?) ";
	    	 PreparedStatement st = (PreparedStatement) con.prepareStatement(sqlquery);
	    	 //System.out.println("hell012");
	    	 st.setString(1,request.getParameter("firstname"));
	    	 st.setString(2,request.getParameter("lastname"));
	    	 st.setString(3,request.getParameter("city"));
	    	 st.setString(4,request.getParameter("mobile"));
	    	 st.setString(5,request.getParameter("password"));
	    	 //st.executeQuery(sqlquery);
	    	 
		if(st.executeUpdate()>0)
		{
			out.println("Registration Successful. Welcome");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		   	  dispatcher.include(request, response);
		}
		else{
			out.println("Sorry, Unable to Register. Please try after some time");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		   	  dispatcher.include(request, response);
		}
	}catch(Exception ex)
	    {
		ex.printStackTrace();
	    }
}
}
}
