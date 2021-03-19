package com.saartha.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saartha.kitchen.connectionprovider;

public class item_mgr {
	
		public static void additem(String name, String unit, int quantity,String cat) throws SQLException {
			// TODO Auto-generated method stub
			items it=new items(name,unit,quantity,cat);
			itemdb(it);
		}
		static Connection con=null;
		private static void itemdb(items it) throws SQLException {
			 con=connectionprovider.connectsql();
			 int c=0;
			try {
				String q1="select item_id from item";
				PreparedStatement pstmt1=con.prepareStatement(q1);
				ResultSet rs=pstmt1.executeQuery();
				while(rs.next()) {
					c=rs.getInt(1);
				}
				String q2="insert into item values(?,?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(q2);
				String name=it.getName();
				String unit=it.getUnit();
				int quantity=it.getQuantity();
				String cat=it.getCat();
				pstmt.setInt(1, ++c);//check for auto
				pstmt.setString(2, name);
				pstmt.setString(3, unit);
				pstmt.setInt(4, quantity);
				pstmt.setString(5, cat);
				int res=pstmt.executeUpdate();
				System.out.println(res);
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public static void delete(int id) throws SQLException {
			try {
				con=connectionprovider.connectsql();
				String q1="delete from item where item_id=?";
				PreparedStatement pstmt=con.prepareStatement(q1);
				pstmt.setInt(1, id);
				int res=pstmt.executeUpdate();
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
		public static void display() {
			con=connectionprovider.connectsql();
			try {
				String q1="select * from item";
				Statement stmt=con.createStatement();
				ResultSet res=stmt.executeQuery(q1);
				while(res.next()) {
					int id=res.getInt(1);
					String name=res.getString(2);
					String unit=res.getString(3);
					int quantity=res.getInt(4);
					String cat=res.getString(5);
					System.out.print(id+"    ");
					System.out.print(name+"    ");
					System.out.print(unit+"   ");
					System.out.print(quantity+"   ");
					System.out.print(cat);
				
				}
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
