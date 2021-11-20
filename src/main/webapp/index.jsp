<%@page import="com.zu.dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@page import="com.zu.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            

            
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		
		
		<%@include file="navbar.jsp" %>
		 
		
		<h1>Welcome  ${USERNAME} To Home Page</h1>
	
	
<%
	 
	ProductDao pro = new ProductDao();
	List<Product> Allpro =	pro.viewAllProduct();
	
	for(Product proSpec : Allpro ){
%>
		<div style="background-color: #f9f9f9 ; margin-bottom: 20px"  >
			<span><%out.print(proSpec.getProductName()); %></span>

			<span><%out.print(proSpec.getBattery()); %></span>

			<span><%out.print(proSpec.getProcessor()); %></span>
			<a href="product.jsp?idR=<%= proSpec.getProductId() %>" >Go</a>
		</div>
		
		
	<% }%>
	
		
	


		
		
	</body>
</html>