package com.line.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NDAOConnection implements ConnectionMaker {
    @Override
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/likelion-db";
        String user = "root";
        String pw = "12345";
        Connection c = DriverManager.getConnection(url,user,pw);
        return c;
    }
}
