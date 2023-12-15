package module2.advance.selenium.DatadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromDataBase {
	public static void main(String[] args) throws SQLException {
		//How to get data from data base.
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement s=c.createStatement();
		String query="select * from studentinfo";
		ResultSet rs=s.executeQuery(query);
		//String out=rs.getString(4);
		//System.out.println(out);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		}
		//String output=rs.getString(3);
		//System.out.println(output);
		c.close();
		
		//Step-1. Create a driver instance
		Driver driver=new Driver();
		//Step-2 Register the Driver
		DriverManager.registerDriver(driver);
		//Step-3 Made connection
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		//Step-4 Create a statement
		Statement statement=connect.createStatement();
		//Step-5 Write a query
		String query3="select lname from studentinfo";
		//Step-6 Execute query
		ResultSet result=statement.executeQuery(query3);
		//Step-7 call the result
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		
		String query1="select lname from studentinfo where lname='Das' and id=1";
		ResultSet rs1=statement.executeQuery(query1);
		//System.out.println(rs.getString(3));
		while(rs1.next()) {
			System.out.println(rs1.getString(1));
		}
		
		
		//Step-8 Close DB.
		connect.close();
		
		//2. How to create data into DB.
		Driver driver3=new Driver();
		DriverManager.registerDriver(driver3);
		Connection connect1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement statement1=connect1.createStatement();
		String query2="insert into studentinfo (id,fname,lname,address) values (8,'Ranjita','Pradhan','Rupsa')";
		int rs2=statement1.executeUpdate(query2);
		if(rs2==1) {
			System.out.println("Query execute successfully...");
		}else {
			System.out.println("Query fail to execute");
		}
		
		connect1.close();
	}

}
