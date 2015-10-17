package com.pms.buisnesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProductFromList {

	/*
	 * This method is for deletion of product on click of delete button
	 */
	public static boolean deleteProduct(int productId)  {
		boolean status=false;
		String driverClass="com.mysql.jdbc.Driver";
		String dbUrl="jdbc:mysql://localhost:3306/pmsdb?&relaxAutoCommit=true";
		String dbUser="root";
		String dbPswd="root";
		
		
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try{
			
			Class.forName(driverClass);
			con=DriverManager.getConnection(dbUrl,dbUser,dbPswd);
			
			pstmt=con.prepareStatement("DELETE FROM `pms_prd_details` WHERE `producid`=?");
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
			con.commit();
			
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			if (con != null) {  
                try {  
                    con.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pstmt != null) {  
                try {  
                    pstmt.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            
		}
		return status;
	}

}
