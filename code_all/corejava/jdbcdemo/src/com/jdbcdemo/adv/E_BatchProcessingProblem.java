package com.jdbcdemo.adv;

import java.sql.*;

import com.jdbcdemo.basics.ConnectionFactory;

public class E_BatchProcessingProblem {

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
				pstmt.addBatch();

				if (i % 10000 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();
				}
			}

			pstmt.executeBatch(); // flush remaining records
			connection.commit(); // Records permanently save

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken: "+ (end-start)+" ms");

	}

}
