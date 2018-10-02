package net.slipp.support.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
    
    public static Connection getConnection() {
        String url = "jdbc:mysql://aws02/slipp_dev?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8";
        String id = "root";
        String pw = "Akdldp!@34";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
