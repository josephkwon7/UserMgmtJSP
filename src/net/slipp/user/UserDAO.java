package net.slipp.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.slipp.support.JdbcTemplate;
import net.slipp.support.PrepareStatementSetter;
import net.slipp.support.RowMapper;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public void addUser(User user) throws SQLException {
        PrepareStatementSetter pss = new PrepareStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getUserId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());
            }
        };
        
        JdbcTemplate template = new JdbcTemplate();
        String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
        template.executeUpdate(sql, pss);
    }

    public User findByUserId(String userId) throws Exception {
        PrepareStatementSetter pss = new PrepareStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, userId);
            }
        };
        
        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                        );
            }
        };
        
        JdbcTemplate template = new JdbcTemplate();
        String sql = "SELECT * FROM users WHERE userId = ?";
        return (User)template.executeQuery(sql, pss, rowMapper);
    }

    public void removeUser(String userId) throws SQLException {
        PrepareStatementSetter pss = new PrepareStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, userId);
            }
        };
        
        JdbcTemplate template = new JdbcTemplate();
        String sql = "DELETE FROM users WHERE userId = ?";
        template.executeUpdate(sql, pss);
    }

    public void updateUser(User user) throws SQLException {
        PrepareStatementSetter pss = new PrepareStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getPassword());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getUserId());
            }
        };
        
        JdbcTemplate template = new JdbcTemplate();
        String sql = "UPDATE users SET password=?, name=?, email=? WHERE userId=?";
        template.executeUpdate(sql, pss);
    }
}
