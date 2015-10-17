package com.pms.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
	boolean create=true;
	String driverClass="com.mysql.jdbc.Driver";
	String dbUrl="jdbc:mysql://localhost:3306/pmsdb";
	String dbUser="root";
	String dbPswd="root";
	
	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;

}
