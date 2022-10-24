package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.database.strategy.AddStrategy;
import com.line.database.strategy.DeleteAllStrategy;
import com.line.database.strategy.JdbcContext;
import com.line.database.strategy.StatementStrategy;
import com.line.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private DataSource dataSource;
    private JdbcContext jdbcContext;
    public UserDAO(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcContext = new JdbcContext(dataSource);
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt){
        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (RuntimeException | SQLException e){
            throw new RuntimeException(e);
        } finally {
            if(ps != null){
                try{
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c != null){
                try{
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }

    public void add(User user) throws SQLException {
        jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into users(id,name,password) values (?,?,?)");
                ps.setString(1,user.getId());
                ps.setString(2,user.getName());
                ps.setString(3,user.getPassword());
                return ps;
            }
        });
    }
    public void deleteAll() throws SQLException {
        jdbcContextWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection.prepareStatement("delete from users");
                return stmt;
            }
        });
    }

    public void getCount() throws SQLException {
        jdbcContextWithStatementStrategy(new StatementStrategy() {
            int cnt = 0;
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection.prepareStatement("select from users");
                ResultSet rs = stmt.getResultSet();

                System.out.println(cnt);
                return stmt;
            }
        });

    }

    public User findById(String id) throws SQLException {
        Connection c = dataSource.getConnection();
        String sql = "select * from users where id = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        User temp = null;

        if(rs.next()) {
            temp = new User();
            temp.setId(rs.getString(1));
            temp.setPassword(rs.getString(2));
            temp.setName(rs.getString(3));
        }

        rs.close();
        ps.close();
        c.close();


        if(temp == null) throw new EmptyResultDataAccessException(1);

        return temp;
    }

    public void select(String id) throws SQLException {
            Connection c = dataSource.getConnection();
            String sql = "select * from users where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
               list.add(user);
            }
            for(User temp : list){
                System.out.printf("id : %3s |", temp.getId());
                System.out.printf("name : %3s |", temp.getName());
                System.out.printf("password : %3s\n",temp.getPassword());
            }

            rs.close();
            ps.close();
            c.close();
    }



}
