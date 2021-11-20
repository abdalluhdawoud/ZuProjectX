package com.zu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	
    public Connection c = null;
	
	 public Connect() throws ClassNotFoundException {

	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver"); 
	            c= DriverManager.getConnection("jdbc:mysql://localhost/technologydb" , "root" , "");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

}
	

}
