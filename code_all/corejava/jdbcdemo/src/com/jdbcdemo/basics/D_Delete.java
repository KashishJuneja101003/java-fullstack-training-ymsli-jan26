package com.jdbcdemo.basics;

import java.sql.*;

//import java.sql.*
public class D_Delete {
	public static void main(String[] args) {
		try{
			
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement pstmt=connection
					.prepareStatement("delete from product where id=?");
					
					pstmt.setInt(1, 5);
					
			int noOfRowsEffected=pstmt.executeUpdate();
			System.out.println(noOfRowsEffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
