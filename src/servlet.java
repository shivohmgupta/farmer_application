

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");			    
	    
	    String name = request.getParameter("act");
	    if(name.equals("Register")){
	   	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
	   	  dispatcher.forward(request, response);
	     }
	else if(name.equals("Login"))
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	   	  dispatcher.forward(request, response);
	}

}
}