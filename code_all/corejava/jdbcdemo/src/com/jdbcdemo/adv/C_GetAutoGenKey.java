package com.jdbcdemo.adv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcdemo.basics.ConnectionFactory;

//import java.sql.*
public class C_GetAutoGenKey {
	public static void main(String[] args) {
		try{
			
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement pstmt=connection
					.prepareStatement("insert into product(name,price)values (?,?)",
							Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, "marker 4");
					pstmt.setDouble(2, 50);
					
			int noOfRowsEffected=pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			 if(rs.next()) {
				 System.out.println(rs.getInt(1));
				 
			 }
			System.out.println(noOfRowsEffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
