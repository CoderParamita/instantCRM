package com.pms.buisnesslogic;

import java.sql.DriverManager;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.pms.servlets.CreateProductDetails;

public class CreteProductWthValidation {
	/*
	 * This fuction is for create new product and checking validation for
	 * duplicate product insertion in database
	 */

	public static boolean createProductWthValidate(String prdName, int qnty, float pce, String vrName) {
		boolean create = true;
		String driverClass = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/pmsdb";
		String dbUser = "root";
		String dbPswd = "root";

		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driverClass);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPswd);

			// checking for duplicate entry of productname
			stmt = con.createStatement();
			;
			rs = stmt.executeQuery("SELECT * FROM `pms_prd_details`");

			while (rs.next()) {

				String s = rs.getString("productname");
				if (s.equalsIgnoreCase(prdName)) {

					create = false;
				}

			}

			if (create) {

				pstmt = con.prepareStatement(
						"insert into pms_prd_details(productname,quantity,price,vendorname) values(?,?,?,?)");
				pstmt.setString(1, prdName);
				pstmt.setInt(2, qnty);
				pstmt.setFloat(3, pce);
				pstmt.setString(4, vrName);
				pstmt.executeUpdate();

			}

			// if not duplicate entry

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

		return create;
	}

}
