package com.jdbcdemo.basics;
import java.sql.*;
//import java.sql.*
public class B_Insert {
	public static void main(String[] args) {
//		load the driver Class Car car=new Car(); static class loading vs dynamic class loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		create connection object

		try(Connection connection=DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ymsli26?useSSL=false", "root", "root")) {
			
			PreparedStatement pstmt=connection
					.prepareStatement("insert into product(name,price)values (?,?)");
					pstmt.setString(1, "water bottle");
					pstmt.setDouble(2, 560);
					
			int noOfRowsEffected=pstmt.executeUpdate();
			System.out.println(noOfRowsEffected);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
