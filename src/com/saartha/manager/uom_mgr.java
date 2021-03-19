package com.saartha.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saartha.kitchen.connectionprovider;

public class uom_mgr {

	public static void add(String unit) {
		uom unit_data=new uom(unit);
		uomdb(unit_data);
	}
	static Connection con=null;
	private static void uomdb(uom unit_data) {
		con=connectionprovider.connectsql();
		int c=0;
		try {
			String q1="select unit_id from uom";
			PreparedStatement pstmt1=con.prepareStatement(q1);
			ResultSet res=pstmt1.executeQuery();
			while(res.next()) {
				c=res.getInt(1);
			}
			String q2="insert into uom values(?,?)";
			PreparedStatement pstmt2=con.prepareStatement(q2);
			String name=unit_data.getUnit_name();
			pstmt2.setInt(1, ++c);
			pstmt2.setString(2, name);
			int result=pstmt2.executeUpdate();
			System.out.println(result);
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void close() {
		if(con!=null) {
			try {
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
