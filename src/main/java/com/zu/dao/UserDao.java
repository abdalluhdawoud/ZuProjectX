package com.zu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.zu.entity.User;

public class UserDao {
	
			
		public void userRegister(User user) throws Exception {
			Connect con = null;
			  try {

				  con = new Connect();
	                PreparedStatement ps= con.c.prepareStatement( "INSERT INTO `users`(`userName`, `email`, `password`, `rePassword`,`isAdmin`) VALUES (?,?,?,?,?)");         
		               
	                ps.setString(1, user.getUsername());	
	                ps.setString(2, user.getEmail());
	                ps.setString(3, user.getPassword());
	                ps.setString(4, user.getRePassword());
	                ps.setInt(   5, user.getIsAdmin());
	                
	                
		             ps.executeUpdate();  
		              		            
		           
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
	           con.c.close();
	        }
		
		}//End Register
		
		
		public ResultSet userLogin(String email , String password) throws ClassNotFoundException, SQLException {
			
			Connect con = new Connect();
			PreparedStatement pr = con.c.prepareStatement("SELECT * FROM users WHERE email = '"+ email +"' && password = '"+ password +"'");
			
			ResultSet res =  pr.executeQuery();		
			
			return res;
		}//End userLogin
		
		

}










