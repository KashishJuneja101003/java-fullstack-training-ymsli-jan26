package com.jdbcdemo.adv;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.jdbcdemo.basics.ConnectionFactory;

//import java.sql.*
public class A_DemoSP {
	public static void main(String[] args) {
		try {
			Connection connection = ConnectionFactory.getConnection();

			CallableStatement  cstmt=connection.prepareCall("call addNum2(?,?,?)");
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 44);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			System.out.println("Result:"+cstmt.getInt(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
