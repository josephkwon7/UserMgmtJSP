package net.slipp.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public Connection getConnection() {
        String url = "jdbc:mysql://aws02/slipp_dev";
        String id = "root";
        String pw = "Akdldp!@34";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());
        System.out.println(pstmt.toString());
        
        pstmt.executeUpdate();
    }

    public User findByUserId(String userId) throws Exception {
        String sql = "SELECT * FROM users WHERE userId = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, userId);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email")
                );
    }

    public void removeUser(String userId) throws SQLException {
        String sql = "DELETE FROM users WHERE userId = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.executeUpdate();
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET password=?, name=?, email=? WHERE userId=?";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getPassword());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getUserId());
        pstmt.executeUpdate();
    }
}