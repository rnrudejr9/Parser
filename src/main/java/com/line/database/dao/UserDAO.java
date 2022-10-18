package com.line.database.dao;

import com.line.database.ConnectionMaker;
import com.line.database.LDAOConnection;
import com.line.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private ConnectionMaker connectionmaker;
    public UserDAO(ConnectionMaker connectionmaker){
        this.connectionmaker = connectionmaker;
    }

    public void add(User user) throws SQLException {
        Connection c = connectionmaker.getConnection();
        String sql = "insert into usertable(id,name,password) values (?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public void deleteAll() throws SQLException {
        Connection c = connectionmaker.getConnection();
        String sql = "delete from usertable";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public void getCount() throws SQLException {
        Connection c = connectionmaker.getConnection();
        String sql = "select * from usertable";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int cnt = 0;
        while(rs.next()){
            cnt++;
        }
        System.out.println("count: " + cnt);

        rs.close();
        ps.close();
        c.close();
    }

    public void select(String id) throws SQLException {
            Connection c = connectionmaker.getConnection();
            String sql = "select * from usertable where id = ?";
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
