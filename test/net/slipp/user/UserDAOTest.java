package net.slipp.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOTest {
    
    private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
    
    private UserDAO userDAO;
    
    @Before
    public void setup() {
        userDAO = new UserDAO();
    }
    
    @Test
    public void crud() throws Exception {
        User user = UserTest.TEST_USER;
        userDAO.removeUser(user.getUserId());
        //new User("userId", "password", "name", "javajigi@slipp.net")
        userDAO.addUser(UserTest.TEST_USER);
        User dbUser = userDAO.findByUserId(user.getUserId());
        logger.debug("dbUser : " + dbUser);
        assertEquals(user, dbUser);
        
        User updatedUser = new User(user.getUserId(), "uPassword", "이름2", "uEmail");
        userDAO.updateUser(updatedUser);
        dbUser = userDAO.findByUserId(updatedUser.getUserId());
        assertEquals(updatedUser, dbUser);
    }
    
    @Test
    public void 존재하지_않는_사용자_조회() throws Exception {
        User user = UserTest.TEST_USER;
        userDAO.removeUser(user.getUserId());
        User dbUser = userDAO.findByUserId(user.getUserId());
        logger.debug("dbUser : {}", dbUser);
        assertNull(dbUser);
    }
    
    @Test
    public void findUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        users = userDAO.findUsers();
        assertTrue(users.size() > 0);
        logger.debug(users.toString());
    }
}
