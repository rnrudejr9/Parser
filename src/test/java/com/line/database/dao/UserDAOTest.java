package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UserDAOTest {
    @Test
    public void deleteAll() throws SQLException {
        ConnectionMaker connectionmaker = new LDAOConnection();
        Connection c = connectionmaker.getConnection();
        String sql = "delete from usertable";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    @Test
    public void add(){

    }

}