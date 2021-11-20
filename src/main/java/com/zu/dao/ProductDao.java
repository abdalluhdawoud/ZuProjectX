package com.zu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zu.entity.Product;


public class ProductDao {
	
	
	
public List<Product> viewAllProduct () throws SQLException  {
		
		
		Connect con = null;
	
		try {
			
			con = new Connect();
			
			
			List<Product> listOp = new ArrayList<Product>();

			Statement statment = con.c.createStatement();
			
			String sql = "SELECT * FROM `products`";
			ResultSet res = statment.executeQuery(sql);
			
			while(res.next()){
				Product product = new Product();
				
				product.setProductId(res.getString("productID"));
				product.setProductName(res.getString("productName"));
				product.setCompanyName(res.getString("companyName"));
				product.setOperatingSystem(res.getString("operatingSystem"));
				product.setBattery(res.getString("battery"));
				product.setProcessor(res.getString("processor"));
				product.setDescription(res.getString("description"));
				
				listOp.add(product);
			}
			
			
			return listOp;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
           con.c.close();

        }
		return null;
				
	}// End viewAllProduct

	



public Product viewProSpe(String proId) throws SQLException  {
	
	Connect con = null;
	Product product = null;
	
	try {
		
		con = new Connect();
		
		String sql = "SELECT * FROM `products` WHERE `productID` = ?";
		
		product = new Product();
		
		PreparedStatement stat = con.c.prepareStatement(sql);
		
		stat.setString(1, proId);

		ResultSet res = stat.executeQuery();
		
		
		while(res.next()){
			
			product.setProductId(res.getString("productID"));
			product.setProductName(res.getString("productName"));
			product.setCompanyName(res.getString("companyName"));
			product.setOperatingSystem(res.getString("operatingSystem"));
			product.setBattery(res.getString("battery"));
			product.setProcessor(res.getString("processor"));
			product.setDescription(res.getString("description"));
			
		}
		
		
		return product;
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
       con.c.close();

    }
	return null;
		
}//End viewProSpe

	
public void updatePro(Product pro) throws SQLException {
		
		Connect con = null;
		
		try {
			con = new Connect();
			String sqlUpd = "UPDATE `products` SET `productName`= ? ,`companyName`= ? ,`operatingSystem`= ? ,`battery`= ? ,`processor`= ? ,`description`= ? WHERE `productID` = ?";
			
			
            PreparedStatement stmt = con.c.prepareStatement(sqlUpd);
            stmt.setString(1, pro.getProductName());
            stmt.setString(2, pro.getCompanyName());
            stmt.setString(3, pro.getOperatingSystem());
            stmt.setString(4, pro.getBattery());
            stmt.setString(5, pro.getProcessor());
            stmt.setString(6, pro.getDescription());
            stmt.setString(7, pro.getProductId());
            
            int resUpdate = stmt.executeUpdate();


            if (resUpdate != 0){
                System.out.println("Updated successfully on the products table");
            }
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
           con.c.close();
        }
		
	}//updatePro
	
	
	public void deletePro(String proId) throws ClassNotFoundException, SQLException {
		
		Connect con = new Connect();
		
		
		PreparedStatement stat = con.c.prepareStatement("DELETE FROM `products` WHERE `productID` = ?");
		
		stat.setString(1, proId);
		
		int res = stat.executeUpdate();
		
        if (res != 0){
            System.out.println("Deleted successfully on the products table");
        }
		
		
	} 
	

}




