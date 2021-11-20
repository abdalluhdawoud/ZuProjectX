package com.zu.controler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zu.dao.Connect;
import com.zu.dao.UserDao;
import com.zu.entity.User;



/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserRegister() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("regisInput") != null){
			
			
			String userName = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_pass");
			String rePassword = request.getParameter("user_rePass");
			
			
//			 ResultSet res = stat.executeQuery("SELECT * FROM users WHERE email ='" + inEmail + "'");
			
			 try {
				 
				 Connect con = new Connect();
	                PreparedStatement ps= con.c.prepareStatement("SELECT * FROM users WHERE email ='" + email + "'");         
	                     
	                ResultSet res = ps.executeQuery();
	               	                
	                res.next();
	                boolean emailFind = false;
	                if (res.getRow() == 1) {
	                    emailFind = true;
	                }
	                
	                String regex = "^(.+)@(.+)$";  
	                Pattern pattern = Pattern.compile(regex);  
	                Matcher matcher = pattern.matcher(email); 
	                boolean isRightEmail = matcher.matches();

				
		            List<String> error = new ArrayList<String>();
		            if (emailFind) {
		                error.add("Not allowed, this email exist !!");
		            }if (isRightEmail != true) {
		                error.add("This Email is not Right");
		            }
		            if (!password.equals(rePassword)) {
		                error.add("password not equal Re-password !!");
		            }
		            if (password.length() < 4) {
		                error.add("Password less 4 !!");
		            }
		            if (userName.length() < 4) {
		                error.add("User name less 4 !!");
		            } else if (error.isEmpty()) {
		            	
		            	UserDao userdao = new UserDao();
		    			User user = new User();
		    			
		    			user.setUsername(userName.toString());
		    			user.setEmail(email.toString());
		    			user.setPassword(password.toString());
		    			user.setRePassword(rePassword.toString());
		    				
		    			userdao.userRegister(user);
		    			
		    			response.sendRedirect("login.jsp");
		    			
		    			
		            }
		            
		            for(String err : error) {
		            	response.getWriter().println(err);
		            }
		         
		            
		            
		            
				 } catch (Exception e) {
						e.printStackTrace();
					}
		}
		
	}

}
