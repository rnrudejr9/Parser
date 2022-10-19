package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DAOFactory.class)
class UserDAOTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void deleteAll() throws SQLException {
        UserDAO userdao = context.getBean("userDao",UserDAO.class);

        UserDAO userDao = new DAOFactory().userDao();
        userDao.getCount();
    }


}