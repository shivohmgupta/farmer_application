

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet("/Servlet1") 

public class login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    try{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(true);
		int number=Integer.parseInt(request.getParameter("mobile"));
		String pass=request.getParameter("password");
		request.getInputStream();
		session.setAttribute("mobile",number);
	System.out.println("Hello");
		boolean status=false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_details?user=root&password=abcdefghijkl");
		try{
			PreparedStatement ps=con.prepareStatement("select * from farmer where phone=? and pass=?");
			ps.setInt(1,number);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
		}catch(Exception e){System.out.println(e);}
		if(status){
			
			RequestDispatcher rd=request.getRequestDispatcher("farmer.jsp");
			//System.out.println("fert");
			rd.forward(request,response);
		}
		else{
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request,response);
		}
    }
    catch(Exception e)
    {}
	}

}
