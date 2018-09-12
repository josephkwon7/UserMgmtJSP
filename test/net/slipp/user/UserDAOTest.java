package net.slipp.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
    
    private UserDAO userDao;
    
    @Before
    public void setup() {
        userDao = new UserDAO();
    }

    @Test
    public void connection() {
        Connection con = userDao.getConnection();
        assertNotNull(con);
    }
    
    @Test
    public void crud() throws Exception {
        User user = UserTest.TEST_USER;
        userDao.removeUser(user.getUserId());
        userDao.addUser(UserTest.TEST_USER);
        User dbUser = userDao.findByUserId(user.getUserId());
        assertEquals(user, dbUser);
        
        User updatedUser = new User(user.getUserId(), "uPassword", "uName", "uEmail");
        userDao.updateUser(updatedUser);
        dbUser = userDao.findByUserId(updatedUser.getUserId());
        assertEquals(updatedUser, dbUser);
    }
    
    @Test
    public void 존재하지_않는_사용자_조회() throws Exception {
        User user = UserTest.TEST_USER;
        userDao.removeUser(user.getUserId());
        User dbUser = userDao.findByUserId(user.getUserId());
        assertNull(dbUser);
    }
}