package com.jdbcdemo.adv;

import java.sql.*;

import com.jdbcdemo.basics.ConnectionFactory;

public class E_BatchProcessing {

	public static void main(String[] args) {
		Connection connection = null;

		PreparedStatement pstmt = null;
		try {

			connection = ConnectionFactory.getConnection();

			connection.setAutoCommit(false);

			pstmt = connection.prepareStatement("INSERT INTO mytemp(name) VALUES (?)");

			for (int i = 1; i <= 10000; i++) {
				pstmt.setString(1, "foo:" + i);
				pstmt.addBatch();

				if (i % 1000 == 0) {
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

	}

}
