package com.pms.buisnesslogic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class SearchProductProcess {
	/*
	 * This method is for particular product in the database by the help of
	 * database. .
	 */

	public ArrayList<ShowProductLIstBean> productSearch(String prdName) {

		ArrayList<ShowProductLIstBean> searchproductdetails = new ArrayList<ShowProductLIstBean>();
		boolean findProduct = false;
		String driverClass = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/pmsdb";
		String dbUser = "root";
		String dbPswd = "root";

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPswd);
			pstmt = con.prepareStatement("select * from pms_prd_details where productname=? ");

			pstmt.setString(1, prdName);

			rs = pstmt.executeQuery();
			ShowProductLIstBean spd1 = null;

			while (rs.next()) {
				System.out.println("In the search while");
				spd1 = new ShowProductLIstBean();
				spd1.setProductName(rs.getString("productname"));
				spd1.setQuantity(rs.getInt("quantity"));
				spd1.setPrice(rs.getFloat("price"));
				spd1.setVname(rs.getString("vendorname"));

				searchproductdetails.add(spd1);

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
		return searchproductdetails;
	}
}
