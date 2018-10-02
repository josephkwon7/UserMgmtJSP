package net.slipp.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcTemplate {
    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);
    
    public void executeUpdate(String sql, PreparedStatementSetter pss) throws SQLException {
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
    
    public void executeUpdate(String sql, Object... parameters) throws SQLException {
        executeUpdate(sql, createPreparedStatementSetter(parameters));
    }
    
    public <T> T executeQuery(String sql, RowMapper<T> rm, PreparedStatementSetter pss) throws Exception {
       List<T> list = list(sql, rm, pss);
       if (list == null || list.isEmpty()) {
           return null;
       }
       return list.get(0);
    }
    
    public <T> T executeQuery(String sql, RowMapper<T> rm, Object... parameters) throws Exception {
        return executeQuery(sql, rm, createPreparedStatementSetter(parameters));
    }

    public <T> List<T> list(String sql, RowMapper<T> rm, PreparedStatementSetter pss) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setParameters(pstmt);
            logger.debug(pstmt.toString());
            
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            rs.previous(); // move cursor to the beginning point again.
            List<T> list = new ArrayList<T>();
            while (rs.next()) {
                list.add(rm.mapRow(rs));
            }
            return list;
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
    
    public <T> List<T> list(String sql, RowMapper<T> rm, Object... parameters) throws Exception {
        return list(sql, rm, createPreparedStatementSetter(parameters));
    }
    
    private PreparedStatementSetter createPreparedStatementSetter(Object... parameters) {
        return new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                for(int i = 0; i < parameters.length; i++) {
                    pstmt.setObject(i+1, parameters[i]);
                }
            }
        };
    }
}
