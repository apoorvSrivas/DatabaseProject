package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		
		 // Load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		// Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password");  
		
		// Create Statement
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("update eproduct set price=1000.00 where name='Tablet'");
		System.out.println("Price is updated.");
		
		// Execute SQL statement
		ResultSet result = stmt.executeQuery("select * from eproduct");
		
		// Process the result
		while(result.next())
		{
			System.out.println("Product ID is: " +result.getInt("ID"));
			System.out.println("Product name is: " +result.getString("name"));
			System.out.println("Price is: " +result.getDouble("price"));
		}
		 
		// Close the connection 
		con.close();
	}

}
