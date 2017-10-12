<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="NewFile.css">
<title>Insert title here</title>
</head>
<body class="body1"  >
<%Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_details?user=root&password=abcdefghijkl");
String phone=(session.getAttribute("mobile").toString()) ;
PreparedStatement ps1=con.prepareStatement("select first_name from farmer where mobile_no=?");
ps1.setString(1,phone);
ResultSet rs1=ps1.executeQuery();
String h=null;
if(rs1.next())
{h=rs1.getString(1);
	}
%>
<h1 align="center" id="h22">Welcome 
<%out.println(h);%></h1>
 <%
 String sqlqueary="SELECT * FROM product_details.product WHERE product_name LIKE '%%' and user_mobile=(?)";
     
	PreparedStatement ps=con.prepareStatement(sqlqueary);
	
	//HttpSession session1=request.getSession();
	ps.setString(1,phone);
	ResultSet rs=ps.executeQuery();
	
	List product_list=new ArrayList();
	 
	
	while (rs.next()) {
		List product=new ArrayList();
  	  product.add(rs.getInt(1));
  	 product.add(rs.getString(2));
  	 product.add(rs.getBlob(3));
  	 product.add(rs.getInt(4));
  	 product.add(rs.getInt(5));
  	  product_list.add(product);
  	  
  	 
  	}
   
  
   if(product_list!=null && product_list.size()>0 ){
 %> <form action="remove.jsp" method="post">
    <div align="center"><table  class="custab">
    <thead >
        <tr>
        	<th>Select</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Pics</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    </thead>
   
    <%
   for(int i=0;i<product_list.size();i++){
	   ArrayList product1=(ArrayList)product_list.get(i);
	
 %>
            <tr>
             <td><input type="checkbox" name="id" value=<%=product1.get(0)%>></td>
                <td><%= product1.get(0)%></td>
                <td><%= product1.get(1)%></td>
                <td><%= product1.get(2)%></td>
                <td><%= product1.get(3)%></td>
                <td><%= product1.get(4)%></td>
            </tr>
              <%
  }
 }
 else{
 %>
  Not Available Any product Details
 <%}%>
 
  <div align="right"  id="div1"><p><input type="submit" value="REMOVE" margin-right="10px">
   </table>
  </form>
 <br></br>
   </div><form action=add.jsp method=post>
 	<div align="left" id="div2"><p><input type="submit" value="ADD" margin-right="10px"></br></p></div></form>

</body>
</html>