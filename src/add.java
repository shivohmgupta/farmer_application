

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
//import javax.websocket.Session;
@WebServlet("/Servlet6")
public class add extends HttpServlet { 
	int rs;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession(false);
		String phone=(session.getAttribute("mobile").toString());
		//System.out.println(phone);
		String n=request.getParameter("productname");
		
		String quan=request.getParameter("quantity");
		
		String price=request.getParameter("price");
	
		boolean status=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_details?user=root&password=abcdefghijkl");
			PreparedStatement ps=con.prepareStatement("Insert into product_details.product(product_name,quantity,price,user_mobile) values(?,?,?,?)");
			ps.setString(1,n);
			ps.setString(2,quan);
			ps.setString(3,price);
			ps.setString(4,phone);
			rs=ps.executeUpdate();
			
			if(rs>0){
				RequestDispatcher rd=request.getRequestDispatcher("farmer.jsp");
				rd.forward(request,response);
				return;
			}
			else{
				
			}
	    }
			
		catch(Exception e){System.out.println(e);}
    }
   
	

}
