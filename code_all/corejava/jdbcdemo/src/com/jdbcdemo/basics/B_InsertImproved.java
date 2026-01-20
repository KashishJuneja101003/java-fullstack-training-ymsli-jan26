package com.jdbcdemo.basics;

import java.sql.*;

//import java.sql.*
public class B_InsertImproved {
	public static void main(String[] args) {
		try{
			
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement pstmt=connection
					.prepareStatement("insert into product(name,price)values (?,?)");
					pstmt.setString(1, "marker");
					pstmt.setDouble(2, 50);
					
			int noOfRowsEffected=pstmt.executeUpdate();
			System.out.println(noOfRowsEffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
