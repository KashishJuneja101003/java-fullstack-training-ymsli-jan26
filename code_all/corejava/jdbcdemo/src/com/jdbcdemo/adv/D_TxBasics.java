package com.jdbcdemo.adv;

import java.sql.*;

import com.jdbcdemo.basics.ConnectionFactory;

public class D_TxBasics {
	public static void main(String[] args) {

		/*
		 * tx mgt we have 2 ways
		 * 1. implicit
		 * 2. declarive tx mgt @Tranactional
		 */
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement pstmt=null;
		try {
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			 pstmt = connection
					.prepareStatement("update account set balance=balance-10 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update acount set balance=balance+10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
