package net.slipp.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public void addUser(User user) {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
        template.executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public User findByUserId(String userId) {
        RowMapper<User> rm = rs -> new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),   
                            rs.getString("email")
                            );
        JdbcTemplate template = new JdbcTemplate();
        String sql = "SELECT * FROM users WHERE userId = ?";
        return template.executeQuery(sql, rm, userId);
    }

    public void removeUser(String userId) {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "DELETE FROM users WHERE userId = ?";
        template.executeUpdate(sql, userId);
    }

    public void updateUser(User user) {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "UPDATE users SET password=?, name=?, email=? WHERE userId=?";
        template.executeUpdate(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findUsers() {
        RowMapper<User> rm = rs -> new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                            );
        JdbcTemplate template = new JdbcTemplate();
        String sql = "SELECT * FROM users";
        return template.list(sql, rm);
    }
}
