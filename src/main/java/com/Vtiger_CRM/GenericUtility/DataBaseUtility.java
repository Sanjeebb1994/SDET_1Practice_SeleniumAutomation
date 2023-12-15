package com.Vtiger_CRM.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	/**
	 * Use to get data from Database.
	 * @param query
	 * @param columnIndex
	 * @return
	 * @throws SQLException
	 */
	public String getDataFromDB(String query, int columnIndex) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery(query);
		String value=rs.getString(columnIndex);
		return value;
	}

}
