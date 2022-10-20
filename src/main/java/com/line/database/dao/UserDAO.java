package com.line.database.dao;

import com.line.database.connection.ConnectionMaker;
import com.line.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

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
        Connection c = null;
        String sql = "delete from usertable";
        PreparedStatement ps = null;

        try{
            c = connectionmaker.getConnection();
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
        } catch (RuntimeException e){
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

    public int getCount() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "select * from usertable";
        try{
            c = connectionmaker.getConnection();
            ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int cnt = 0;
            while (rs.next()){
                cnt++;
            }
            System.out.println("count: " + cnt);
            return cnt;
        }catch (RuntimeException e){
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

    public User findById(String id) throws SQLException {
        Connection c = connectionmaker.getConnection();
        String sql = "select * from usertable where id = ?";
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
