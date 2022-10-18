package com.line.database;

import com.line.domain.Hospital;
import com.line.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UserDAO {
    public UserDAO(){

    }
    abstract Connection getConnection() throws SQLException;

    public void add(User user) throws SQLException {
        Connection c = getConnection();
        String sql = "insert into usertable(id,name,password) values (?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public void delete(User user) throws SQLException {
        Connection c = getConnection();
        String sql = "delete from usertable";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public void search() throws SQLException {
            Connection c = getConnection();
            String sql = "select * from usertable";
            PreparedStatement ps = c.prepareStatement(sql);
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
                System.out.println(temp.getId());
                System.out.println(temp.getName());
                System.out.println(temp.getPassword());
            }

            ps.close();
            c.close();
    }
}
