package com.saartha.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saartha.kitchen.connectionprovider;

public class cat_mgr {

	public static void addcat(String cat_name) {
		category cat=new category(cat_name);
		cat_db(cat);
	}
	static Connection con=null;
	private static void cat_db(category cat) {
		// TODO Auto-generated method stub
		int c=0;
		 con=connectionprovider.connectsql();
		try {
			String q1="select ca_id from category";
			PreparedStatement pstmt1=con.prepareStatement(q1);
			ResultSet rs=pstmt1.executeQuery();
			while(rs.next()) {
				c=rs.getInt(1);
			}
			String q2="insert into category values(?,?)";
			PreparedStatement pstmt2=con.prepareStatement(q2);
			String name=cat.getName();
			pstmt2.setInt(1, ++c);
			pstmt2.setString(2, name);
			int res=pstmt2.executeUpdate();
			System.out.println(res);
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void close() {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
