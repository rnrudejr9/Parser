package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;

public class DAOFactory {
    public UserDAO userDao(){
        return new UserDAO(connectionMaker());
    }
    public ConnectionMaker connectionMaker(){
        return new LDAOConnection();
    }
}
