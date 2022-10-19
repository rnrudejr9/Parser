package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.connection.LDAOConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOFactory {

    @Bean
    public UserDAO userDao(){
        return new UserDAO(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new LDAOConnection();
    }
}
