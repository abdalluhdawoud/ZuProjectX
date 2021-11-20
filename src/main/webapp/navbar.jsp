<%@page import="javax.swing.text.html.HTMLEditorKit.Parser"%>
<%@page import="com.zu.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
	
	ul li {
		
		margin-left: 10px;
		margin-top: 5px;
		display: inline-block;
		background-color: #f9f9f9;
		padding: 10px;
		
	}
	
</style>

<body>
	
	<ul>
		<li> <a href="index.jsp" >Home</a> </li>
		<li>Phone</li>
		<li>Tablet</li>
		<li>Laptop</li>
		<%
		if(session.getAttribute("USERNAME") != null){
			UserDao usDa = new UserDao();
		    
			int isAd = Integer.parseInt(session.getAttribute("ISADMIN").toString());
			
			if(isAd == 1){
		%>		
				<li> <a href="adminpage.jsp" >Admin Page</a></li>
					
		<%  }else{ %>
			
			<li><%out.print(session.getAttribute("USERNAME").toString()); %></li>
			
		<%	} %>
			
		<% }%>
		
		<% if(session.getAttribute("USERID") == null){ %>
		
		<li> <a href="login.jsp" >Login</a> </li>
		<li> <a href="registerJSP.jsp" >Register</a> </li>
		<% }else{%>
			
			<li><a href="Logout">LogOut</a></li>
			
		<%}%>
	</ul>
	

</body>
</html>