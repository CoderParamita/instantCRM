package com.pms.buisnesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowProduclist {
	/*
	 * This method is for showing product list from database
	 * 
	 */
	public ArrayList<ShowProductLIstBean> showProductlist() {

		ArrayList<ShowProductLIstBean> productdetails = new ArrayList<ShowProductLIstBean>();

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

			pstmt = con.prepareStatement("SELECT * FROM `pms_prd_details`");
			rs = pstmt.executeQuery();

			ShowProductLIstBean spd = null;
			while (rs.next()) {

				spd = new ShowProductLIstBean();
				spd.setProductId(rs.getInt("producid"));
				spd.setProductName(rs.getString("productname"));
				spd.setQuantity(rs.getInt("quantity"));
				spd.setPrice(rs.getFloat("price"));
				spd.setVname(rs.getString("vendorname"));

				productdetails.add(spd);

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

		return productdetails;
	}

}
