package net.slipp.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.slipp.support.JdbcTemplate;
import net.slipp.support.RowMapper;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public void addUser(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
        template.executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public User findByUserId(String userId) throws Exception {
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {
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
        return template.executeQuery(sql, rm, userId);
    }

    public void removeUser(String userId) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "DELETE FROM users WHERE userId = ?";
        template.executeUpdate(sql, userId);
    }

    public void updateUser(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "UPDATE users SET password=?, name=?, email=? WHERE userId=?";
        template.executeUpdate(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findUsers() throws Exception {
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {
                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                        );
            }
        };
        JdbcTemplate template = new JdbcTemplate();
        String sql = "SELECT * FROM users";
        return template.list(sql, rm);
    }
}
