package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.strategy.AddStrategy;
import com.line.database.strategy.DeleteAllStrategy;
import com.line.database.strategy.JdbcContext;
import com.line.database.strategy.StatementStrategy;
import com.line.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void add(User user) {
        this.jdbcTemplate.update("insert into users(id,name,password) values (?,?,?)",user.getId(),
                user.getName(),user.getPassword());
    }
    public void deleteAll() {
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("delete from users");
            }
        });
    }



    public User findById(String id) throws SQLException {
        String sql = "select * from users where id =? ";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
                return user;
            }
        };

        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    public List<User> getAll(){
        String sql = "select * from users order by id";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.query(sql, rowMapper);
    }



}
