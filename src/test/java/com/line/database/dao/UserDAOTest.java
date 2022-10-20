package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
import com.line.domain.User;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DAOFactory.class)
class UserDAOTest {
    UserDAO userDao;
    User user1;
    User user2;
    User user3;
    @Autowired
    ApplicationContext context;

    @BeforeEach
    void setUp(){
        this.userDao = context.getBean("userDao",UserDAO.class);
        this.user1 = new User("1","1","1");
        this.user2 = new User("2","2","2");
        this.user3 = new User("3","3","3");
    }

    @Test
    void addAndGet() throws SQLException {

        userDao.deleteAll();

        userDao.add(user2);
        User user = userDao.findById("2");

        assertEquals(user2.getId(),user.getId());
    }

    @IgnoreForBinding
    void findById(){
        assertThrows(EmptyResultDataAccessException.class,()->{
            userDao.findById("30");
        });
        System.out.println("ignore");
    }

    @AfterEach
    void count() throws SQLException {
        User user1 = new User("1","hello","1234");
        User user2 = new User("2","sdsd","1234");
        User user3 = new User("3","helsalo","1234");

        userDao.deleteAll();
        assertEquals(0,userDao.getCount());

        userDao.add(user1);
        assertEquals(1,userDao.getCount());
        userDao.add(user2);
        assertEquals(2,userDao.getCount());
        userDao.add(user3);
        assertEquals(3,userDao.getCount());
        System.out.println("aftereach");
    }
    @Test
    public void deleteAll() throws SQLException {

        UserDAO userDao = new DAOFactory().userDao();
        userDao.getCount(); //delete -> getcount;
    }


}