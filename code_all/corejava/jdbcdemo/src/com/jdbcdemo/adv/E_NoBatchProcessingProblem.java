package com.jdbcdemo.adv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbcdemo.basics.ConnectionFactory;

public class E_NoBatchProcessingProblem {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = ConnectionFactory.getConnection();

			connection.setAutoCommit(false);

			pstmt = connection.prepareStatement("INSERT INTO mytemp(name) VALUES (?)");

			for (int i = 1; i <= 1000000; i++) {
				pstmt.setString(1, "foo:" + i);

				pstmt.executeUpdate();
			}
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("time taken: "+ (end-start)+" ms");
		
	}
}
