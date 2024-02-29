package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectUtils;
import model.cart;
import model.product;

public  class CartService {

	
	public static void insertToCart(int idProduct,int idUser ) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "INSERT INTO carts ( idProduct, idUser) VALUES (?, ?)";
		try {
			conn = ConnectUtils.openConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idProduct);
			ps.setInt(2,idUser);
			ps.execute();
		} catch (Exception e) {
		}}
	  public static void DelCart(int idProduct,int idUser) {
			 
		  try {
				Connection conn=ConnectUtils.openConnect();
				String query="delete from carts where idProduct= ? and idUser= ?";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1,idProduct);
				stmt.setInt(2,idUser);
				boolean rs = stmt.execute();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
	 }
	public static ArrayList<product> getAllCart(int idUser) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<product> products = new ArrayList<>();
		String query = "SELECT  p.id,p.name, p.price, p.img FROM carts AS c JOIN user AS u ON c.iduser = u.id"
				+ " JOIN products AS p ON c.idproduct = p.id where iduser=?";
		try {
			conn =ConnectUtils.openConnect();
			ps = conn.prepareStatement (query);
			ps.setInt(1, idUser);
			rs=ps.executeQuery();
			while (rs.next()) {
				product pro=new product();
				pro.setID(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getDouble("price"));
				pro.setImg(rs.getString("img"));
				products.add(pro);}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	public static ArrayList<cart> getCart() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<cart> carts = new ArrayList<>();
		String query = "SELECT * from carts";
		try {
			conn =ConnectUtils.openConnect();
			ps = conn.prepareStatement (query);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				cart c=new cart();
				c.setId(rs.getInt("id"));
				c.setIdProduct(rs.getInt("idProduct"));
				c.setIdUser(rs.getInt("idUser"));
				c.setQuantity(rs.getInt("quantity"));
				carts.add(c);}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carts;
	}
	}
