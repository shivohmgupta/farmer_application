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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");		
		String url = "jdbc:mysql://localhost:3306/";
		String db_farmer = "farmer_details";
		String db_customer = "customer_details";		
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "abcdefghijkl";
	    
	    PrintWriter out = response.getWriter();
	    
		String choice=request.getParameter("choice");
		if(choice.equals("farmer"))
		{
			try
			{
				HttpSession session=request.getSession(true);
				Class.forName(driver);
				Connection con = (Connection) DriverManager.getConnection(url+db_farmer, user, pass);
				//System.out.println("hell0");
				String sqlquery="select first_name, password from farmer  where mobile_no=(?) and password=(?) ";
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sqlquery);
				String password=request.getParameter("password");
				String mobile = request.getParameter("mobile");
				request.getInputStream();
				session.setAttribute("mobile",mobile);
				boolean status=false;
				st.setString(1,mobile);
				st.setString(2,password);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{	
					String first  = rs.getString(1);
					String pas = rs.getString(2);
					// if(password.equals(pas))
					//	{
					out.println("Welcome " + first + " " );
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/farmer.jsp");
					dispatcher.include(request, response);
					//  rs.close();
					//}
	    		 }
				else
				{
					out.println("Sorry, You are not Registered. Kindly go to registration page");
		    		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				   	  dispatcher.include(request, response);
				  // 	  rs.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}	
	    
		}
		else if(choice.equals("customer"))
		{
			try
			{
				Class.forName(driver);
				Connection con = (Connection) DriverManager.getConnection(url+db_customer, user, pass);
				//System.out.println("hell0");
				String sqlquery="select first_name, password from customer  where mobile_no=(?) and password=(?) ";
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sqlquery);
				String password=request.getParameter("password");
				String mobile = request.getParameter("mobile");
				
				st.setString(1,mobile);
				st.setString(2,password);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{	
					String first  = rs.getString(1);
					String pas = rs.getString(2);
					// if(password.equals(pas))
					//	{
					//out.println("Welcome " + first + " " );
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/customer_homepage.jsp");
					dispatcher.include(request, response);
					//  rs.close();
					//}
	    		 }
				else
				{
					out.println("Sorry, You are not Registered. Kindly go to registration page");
		    		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				   	  dispatcher.include(request, response);
				  // 	  rs.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}	
		}
	}
	

}
