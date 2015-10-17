package com.pms.buisnesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowProducDetailsForEdit {
	/*
	 * This method is for showing product details from database for edit or
	 * update database.
	 */
	public static boolean showProductDetails(String prdcName, int qnty, float price, String vendorName) {
		// TODO Auto-generated constructor stub
		String driverClass = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/pmsdb";
		String dbUser = "root";
		String dbPswd = "root";
		boolean status = false;
		Statement stmt = null;

		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;

		String id = null;

		try {
			Class.forName(driverClass);

			con = DriverManager.getConnection(dbUrl, dbUser, dbPswd);

			sql = "select * from pms_prd_details";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			status = rs.next();

			while (rs.next()) {
				id = rs.getString(1);
				prdcName = rs.getString(2);
				qnty = rs.getInt(3);
				price = rs.getFloat(4);
				vendorName = rs.getString(5);

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
