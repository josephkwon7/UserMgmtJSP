package net.slipp.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcTemplate {
    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);
    
    public void executeUpdate(String sql, PrepareStatementSetter pss) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setParameters(pstmt);
            logger.debug(pstmt.toString());
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public Object executeQuery(String sql, PrepareStatementSetter pss, RowMapper rm) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            
            return rm.mapRow(rs);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
