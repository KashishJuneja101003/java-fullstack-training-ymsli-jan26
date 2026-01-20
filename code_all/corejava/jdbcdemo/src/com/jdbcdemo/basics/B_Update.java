package com.jdbcdemo.basics;

import java.sql.*;

//import java.sql.*
public class B_Update {
	public static void main(String[] args) {
		try{
			
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement pstmt=connection
					.prepareStatement("update product set price=? where id=?");
					
					pstmt.setDouble(1, 56);
					pstmt.setInt(2, 5);
					
			int noOfRowsEffected=pstmt.executeUpdate();
			System.out.println(noOfRowsEffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
