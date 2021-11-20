<%@page import="java.util.List"%>
<%@page import="com.zu.dao.ProductDao"%>
<%@page import="com.zu.dao.Connect"%>
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
	
	
	<%
	
	String proId = request.getParameter("idR"); 
	
	ProductDao pro = new ProductDao();
	Product proSpe =	pro.viewProSpe(proId);
	
	out.print("Product Name : " + proSpe.getProductName() + "<br/>");
	
	out.print("Made By : " + proSpe.getCompanyName()+ "<br/>");
	out.print("OS : " + proSpe.getOperatingSystem()+ "<br/>");
	out.print("Processor : " + proSpe.getProcessor()+ "<br/>");
	out.print("Battery : " + proSpe.getBattery()+ "<br/>");	
	
	%>
	
</body>

</html>










