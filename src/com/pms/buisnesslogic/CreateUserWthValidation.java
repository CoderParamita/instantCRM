package com.pms.buisnesslogic;

import java.sql.Connection;
import com.pms.dbcon.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserWthValidation {
	/*
	 * This method is for creating New user with the validation of insertion
	 * of duplicate user name
	 */
	public static boolean createuser(String userName, String password) {
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

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `pms_login_details`");

			while (rs.next()) {

				String s = rs.getString("username");
				if (s.equalsIgnoreCase(userName)) {

					create = false;
				}

			}

			if (create) {

				pstmt = con.prepareStatement("insert into pms_login_details(username,password) values(?,?)");
				pstmt.setString(1, userName);

				pstmt.setString(2, password);
				pstmt.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (NumberFormatException e) {

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
