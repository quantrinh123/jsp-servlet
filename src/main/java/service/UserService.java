package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import connect.ConnectUtils;
import model.User;
import model.product;

public class UserService {
	public static User CheckLogin( String username,String password){	
		 String query = "SELECT * FROM user where username = ? and password = ? ";

		try {
			Connection conn=ConnectUtils.openConnect();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return (new User (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getInt(4)
						  ));
			}
			
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		return null;
	}
	public static User checkAccountExist(String UserName) {
		String query = "select * from user where username = ? ";
		try {
			Connection conn = ConnectUtils.openConnect();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,UserName);
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				return (new User (rs.getInt(1),
									  rs.getString (2),
									  rs.getString (3),
									  rs.getInt(4)
									  ));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static User singUp (String UserName, String PassWord) {
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String query = "INSERT INTO user (username,password) VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, UserName);
			stmt.setString(2,PassWord);
			boolean rs=	stmt.execute();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}
	public static boolean CheckLoginAdmin(String user, String pass) {
	    String query = "SELECT * FROM user WHERE username = ? AND password = ? AND role = '1' ";
	    try (Connection conn =  ConnectUtils.openConnect();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        ResultSet rs = ps.executeQuery();

	        // If user is found, return true
	        if (rs.next()) {
	            return true;
	        }
	    } catch (SQLException e) {
	        // Log the error
	        e.printStackTrace();
	    }
	    return false;
	}
}
