<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="UserRegister" method="POST">
		
		<label>User Name</label>
		<input type = "text" name = "user_name">
		<br>
		<label>Email</label>
		<!-- <input type = "email" name = "user_email" >-->
		<input type = "text" name = "user_email" >
		<br>
		<label>password</label>
		<input type = "password" name = "user_pass" >
		<br>
		<label>Re_password</label>
		<input type = "password" name = "user_rePass" >
		<br>
		<input type = "submit" name = "regisInput" ><br>
		
		<a href="login.jsp" >Login</a> 
		
	</form>
	
	
	


</body>
</html>