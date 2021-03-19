package com.saartha.kitchen;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionprovider {
		static Connection con;
		public static Connection connectsql() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/kitchen_items";
				String user="root";
				String pwd="tiger";
				con=DriverManager.getConnection(url,user,pwd);
				
			} catch (Exception e) {
			e.printStackTrace();
			}
			return con;
		}
}
