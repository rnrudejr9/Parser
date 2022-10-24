package com.line.database.strategy;

import com.line.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements StatementStrategy{

    public User user;

    public AddStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into user(id,name,password) values (?,?,?)");
        ps.setString(1,this.user.getId());
        ps.setString(2,this.user.getName());
        ps.setString(3,this.user.getPassword());
        return ps;
    }
}
