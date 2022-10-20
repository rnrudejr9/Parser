package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DAOFactory.class)
class UserDAOTest {
    @Autowired
    ApplicationContext context;

    @Test
    void addAndGet() throws SQLException {
        User user1 = new User("4","hell","123");

        UserDAO userDao = context.getBean("userDao",UserDAO.class);
        userDao.deleteAll();

        userDao.add(user1);
        User user = userDao.findById("4");

        assertEquals(user1.getId(),user.getId());
    }

    @Test
    void count() throws SQLException {
        User user1 = new User("1","hello","1234");
        User user2 = new User("2","sdsd","1234");
        User user3 = new User("3","helsalo","1234");

        UserDAO userDao = context.getBean("userDao", UserDAO.class);
        userDao.deleteAll();
        assertEquals(0,userDao.getCount());

        userDao.add(user1);
        assertEquals(1,userDao.getCount());
        userDao.add(user2);
        assertEquals(2,userDao.getCount());
        userDao.add(user3);
        assertEquals(3,userDao.getCount());
    }
    @Test
    public void deleteAll() throws SQLException {
        UserDAO userdao = context.getBean("userDao",UserDAO.class);

        UserDAO userDao = new DAOFactory().userDao();
        userDao.getCount();
    }


}