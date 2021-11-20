<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="UserLogin" method="POST">
		
		Enter Email : <input type="text" name= "user_email" ><br>
		Enter Password : <input type="password" name = "user_pass" ><br>
		<input type="submit" name ="loginInput" value="Login" ><br>
		<a href="registerJSP.jsp" >Register</a> 
		
		
	</form>
	
</body>
</html>