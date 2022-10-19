package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UserDAOTest {
    @Test
    public void deleteAll() throws SQLException {
        UserDAO userDao = new DAOFactory().userDao();
        userDao.getCount();
    }

    @Test
    public void add(){

    }

}