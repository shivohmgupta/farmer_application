<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Bootstrap core CSS -->
 <link rel="stylesheet" type="text/css" href="search_output.css" />
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>Products List</title>
</head>
<body>
<%
List booklist= new ArrayList();
booklist= (ArrayList)request.getAttribute("booklist");
if(booklist!=null && booklist.size()>0){
%>
<div class="table1">
	<div class="result">
<h1>
<strong>Results</strong>
</h1>
</div>
<table class="table-striped">
  <thead>
    <tr>
      <th>S.No</th>
      <th>name</th>
      <th>quantity</th>
    </tr>
  </thead>
  <%
  for(int i=0; i<booklist.size(); i++){
	  List book=(List)booklist.get(i);
  %>
  
  <tbody>
    <tr>
      <td scope="row"><%=book.get(0) %></td>
      <td><%=book.get(1) %></td>
      <td><%=book.get(3) %></td>
      
    </tr>
     <%
    }
 }else{
 %>
  Not Available Any Product Details
 <%}%>
  </tbody>
</table>


</div>
</body>
</html>