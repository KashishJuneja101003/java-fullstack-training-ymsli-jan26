package com.jdbcdemo.adv;

import java.sql.*;

import com.jdbcdemo.basics.ConnectionFactory;

//import java.sql.*
public class A_Read {
	public static void main(String[] args) {
//		load the driver Class Car car=new Car(); static class loading vs dynamic class loading
		
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			
			DatabaseMetaData dbmd=connection.getMetaData();  
			 
			
			ResultSet tables = dbmd.getTables(
			        "ymsli26",        // catalog (usually null)
			        "ymsli26",        // schema pattern
			        "%",         // table name pattern
			        new String[]{"TABLE"} // types: TABLE, VIEW, SYSTEM TABLE
			);

			while (tables.next()) {
			    String tableName = tables.getString("TABLE_NAME");
			    String schema = tables.getString("TABLE_SCHEM");
			    System.out.println(schema + "." + tableName);
			}
			
			
			
			
			
			
//			System.out.println("Driver Name: "+dbmd.getDriverName());  
//			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
//			System.out.println("UserName: "+dbmd.getUserName());  
//			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
//			System.out.println
//			("Database Product Version: "+dbmd.getDatabaseProductVersion());
//			
			
			
//			Statement stmt=connection.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from product");
//			
//			ResultSetMetaData rsMeta=rs.getMetaData();
//			System.out.println("No of column:"+rsMeta.getColumnCount());
//			
//			for(int i=1;i<=rsMeta.getColumnCount();i++){
//				System.out.println(rsMeta.getColumnClassName(i)+": ");
//			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
