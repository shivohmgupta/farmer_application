

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductClass
 */
@WebServlet("/search_product")
public class search_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public search_product() {
        super();
        // TODO Auto-generated constructor stub
    }
	///@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String url = "jdbc:mysql://localhost:3306/";
		String db_product = "product_details";
		
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "abcdefghijkl";
		PrintWriter out= response.getWriter();
		List booklist=new ArrayList();
		
		String query= request.getParameter("search");
		
		
		try{
			Class.forName(driver);
			Connection con = (Connection) DriverManager.getConnection(url+db_product, user, pass);
			
			PreparedStatement ps=con.prepareStatement("select * from product where product_name=?");
			
			ps.setString(1,query);
			
			ResultSet rs=ps.executeQuery();		
			while (rs.next()){
		    	  List book=new ArrayList();
		    	  book.add(rs.getInt(1));
		    	  book.add(rs.getString(2));
		    	  book.add(rs.getBlob(3));
		    	  book.add(rs.getInt(4));
		    	  book.add(rs.getInt(5));
		    	  book.add(rs.getDouble(6));
		    	  booklist.add(book);
		    	}
			
			request.setAttribute("booklist",booklist);  
			  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/search_output.jsp");
			  dispatcher.forward(request, response);	
		}
		
		catch(Exception e){e.printStackTrace();}
		
	}

}
