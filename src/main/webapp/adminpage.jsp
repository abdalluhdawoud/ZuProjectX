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
		
		<%
	
			if(session.getAttribute("USERNAME") == null ){
				response.sendRedirect("login.jsp");
			}else{
				
				int isAd = Integer.parseInt(session.getAttribute("ISADMIN").toString());
				if(isAd != 1){
					
				response.sendRedirect("login.jsp");
					
				}
			}
		%>
	
		<% 
		
			ProductDao proD = new ProductDao();
			
			List<Product> proObjects =  proD.viewAllProduct();
		
		%>
		
		
		
		<table border="1">
		
			<!-- Edit Button Start -->
			
			<%if(request.getParameter("editBtnId") != null){
				
				Product proSps = proD.viewProSpe(request.getParameter("proId"));
					
			%>
			
			<tr>		
				<form method="post" action="adminpage.jsp">
					<td>
						<input hidden="" value="<%= proSps.getProductId() %>" name = "pro_id" >
						<%= proSps.getProductId() %>
					</td>
					
					<td><input value="<%= proSps.getProductName() %>" name = "pro_name" ></td>
					<td><input value="<%= proSps.getCompanyName() %>" name = "comp_name" ></td>
					<td><input value="<%= proSps.getOperatingSystem() %>" name = "oper+system" ></td>
					<td><input value="<%= proSps.getBattery()%>" name = "pro_battery" ></td>
					<td><input value="<%= proSps.getProcessor() %>" name = "pro_procrss" ></td>
					<td><input value="<%= proSps.getDescription()%>" name = "pro_description" ></td>
		
					<td><input type="submit" value="Update" name = "updateBtnId" ></td>
					<td><input type="submit" value="Exit"  ></td>
				</form>
			</tr>
				
				
			<%}%>
			
			<!-- Edit Button End -->
			
			<!-- Update Button Start -->
				<%if(request.getParameter("updateBtnId") != null){
		
				String productId = request.getParameter("pro_id");
				String productName = request.getParameter("pro_name");
				String companyName = request.getParameter("comp_name");
				String operatingSystem = request.getParameter("oper+system");
				String battery = request.getParameter("pro_battery");
				String processor = request.getParameter("pro_procrss");
				String description = request.getParameter("pro_description");
				
				Product pro = new Product();
				
				pro.setProductId(productId);
				pro.setProductName(productName);
				pro.setCompanyName(companyName);
				pro.setOperatingSystem(operatingSystem);
				pro.setBattery(battery);
				pro.setProcessor(processor);
				pro.setDescription(description);
				
				proD.updatePro(pro);
				
				response.sendRedirect("adminpage.jsp");
				} %>
				
			
			<!-- Update Button End -->
			
			<!-- Delete Button Start -->
				
					<% if(request.getParameter("isDeleteBtn") != null){ %>
					
						<form method="get">
							<input hidden="" type="text" value="<%=request.getParameter("proIdWhithDel")%>" name = "proIdToDel">
							<p>Do you want to delete ?</p>
							<input type="submit" value="Yes" name ="deleteBtn">
							&nbsp;
							<input type="submit" value="No">
						</form>					
						
					<%	}
					
						if(request.getParameter("deleteBtn") != null){ 
							String productId = request.getParameter("proIdToDel");
							proD.deletePro(productId);		
							response.sendRedirect("adminpage.jsp");
						}
					%>
	
			<!-- Delete Button End -->
		
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>company Name</td>
			<td>OS</td>
			<td>Battery</td>
			<td>Processor</td>
			<td>Description</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		
		<% %>
		
		<% for(Product proObj: proObjects){ %>
		
			<tr> 
				<td><%=proObj.getProductId()%></td>
				<td><%=proObj.getProductName()%></td>
				<td><%=proObj.getCompanyName()%></td>
				<td><%=proObj.getOperatingSystem()%></td>
				<td><%=proObj.getBattery()%></td>
				<td><%=proObj.getProcessor()%></td>
				<td><%=proObj.getDescription()%></td>
				<td>
					<form method="post">	
						<input hidden="" type = "text" value="<%=proObj.getProductId()%>"  name = "proId">
						<input type="submit" value="Edit" name = "editBtnId" >
					</form>		
				</td>
				
				<td>
					<form method="post">	
						<input hidden="" type = "text" value="<%=proObj.getProductId()%>"  name = "proIdWhithDel">
						<input type="submit" value="Delete" name = "isDeleteBtn" >
					</form>		
				</td>
				
				
	
			</tr>
			
		<%} %>
		</table>
		
	
	</body>
</html>