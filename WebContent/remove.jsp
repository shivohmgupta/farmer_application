<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
//System.out.println("Hello");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_details?user=root&password=abcdefghijkl");
//System.out.println("Hello1");
String select[] = request.getParameterValues("id");
//out.println(select);
//System.out.println("Hello12");
if (select != null && select.length != 0) {
//out.println("You have deleted product id: ");
//System.out.println("Hello123");
for (int i = 0; i < select.length; i++) {
//out.println(select[i]);
 String sqlqueary="Delete FROM product_details.product WHERE pid=?";

PreparedStatement ps=con.prepareStatement(sqlqueary);
String h=(select[i]).toString();
ps.setString(1,h);
ps.executeUpdate(); 
}
RequestDispatcher rd=request.getRequestDispatcher("/farmer.jsp");
rd.forward(request,response);

}


%>
</body>
</html>