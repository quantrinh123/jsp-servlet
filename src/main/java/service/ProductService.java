package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


import connect.ConnectUtils;

import model.product;

public class ProductService {
	public static ArrayList<product> findAll(){
		ArrayList<product> products=new ArrayList<product>();
		
		try {
			Connection conn=ConnectUtils.openConnect();
			String query="select * from products ORDER BY date DESC";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product pro=new product();
				pro.setID(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getDouble("price"));
				pro.setDcri(rs.getString("dcri"));
				pro.setImg(rs.getString("img"));
				products.add(pro);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}
  public static product findById(int id) {
	  product pro=new product();
	  try {
			Connection conn=ConnectUtils.openConnect();
			String query="select * from products where id= ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
				pro.setID(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getDouble("price"));
				pro.setDcri(rs.getString("dcri"));
				pro.setImg(rs.getString("img"));
			
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pro;
  }
  public static void removeById(int id) {
	 
	  try {
			Connection conn=ConnectUtils.openConnect();
			String query="delete from products where id= ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,id);
			boolean rs = stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
 }
  public static void add(String Name,double Price,String Dcri,String Img,Timestamp timestamp2) {		 
	  try {
			Connection conn=ConnectUtils.openConnect();
			String query="INSERT INTO products (name, price, dcri,Img,date) VALUES (?, ?, ?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,Name);
			stmt.setDouble(2,Price);
			stmt.setString(3,Dcri);
			stmt.setString(4,Img);
			LocalDateTime currentTime = LocalDateTime.now();
	        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(currentTime);
	        stmt.setTimestamp(5, timestamp);
			boolean rs = stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
 }
  public static void update(String Name,double Price,String Dcri,int id,String Img) {		 
	  try {
			Connection conn=ConnectUtils.openConnect();
			String query="UPDATE products SET name= ?,img=?, price= ?, dcri= ? where id= ?";
			PreparedStatement stmt = conn.prepareStatement(query);		
			stmt.setString(1,Name);
			stmt.setDouble(3,Price);
			stmt.setString(4,Dcri);
			stmt.setString(2,Img);
			stmt.setInt(5,id);
			boolean rs = stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
 }
  public static ArrayList<product> search(String str){
		ArrayList<product> products=new ArrayList<product>();
		
		try {
			Connection conn=ConnectUtils.openConnect();
			String query="select * from products where name like ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,"%"+str+"%");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product pro=new product();
				pro.setID(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getDouble("price"));
			    pro.setDcri(rs.getString("dcri"));
			    pro.setImg(rs.getString("img"));
				products.add(pro);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}
}
