package com.pms.buisnesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProductDetails {
	/*
	 * This method is for update the product details.
	 * 
	 */
	public static boolean updateDetails(int productId, String prdName, int qnty, float pce, String vrName) {
		String driverClass = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/pmsdb";
		String dbUser = "root";
		String dbPswd = "root";
		boolean status = true;
		Statement stmt = null;

		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPswd);
			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT * FROM `pms_prd_details`");

			if (status) {

				pstmt = con.prepareStatement(
						"UPDATE  `pms_prd_details` SET  `productname`=?,`quantity`=?, `price`=?,`vendorname`=? WHERE `producid`=?");

				pstmt.setString(1, prdName);
				pstmt.setInt(2, qnty);
				pstmt.setFloat(3, pce);
				pstmt.setString(4, vrName);
				pstmt.setInt(5, productId);
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return status;

	}

}
