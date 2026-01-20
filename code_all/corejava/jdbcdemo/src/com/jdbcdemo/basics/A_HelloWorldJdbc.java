package com.jdbcdemo.basics;
import java.sql.*;
//import java.sql.*
public class A_HelloWorldJdbc {
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
			
			System.out.println("conn is done");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from product");
//			execute sql statements, create RS object, Fetch new row,manipulate data of that row...
//			Fetch last row?
			while(rs.next()) {
				System.out.println(rs.getInt(1)+": "+rs.getString(2)+": "+ rs.getDouble(3));
			}
			
		//	Statement vs PrepareStatement vs CallableStatement(SP)
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
