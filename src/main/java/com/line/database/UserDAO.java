package com.line.database;

import com.line.domain.Hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {
    private int id;
    private String password;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDAO(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public void add(UserDAO dao){
        try {
            String url = "jdbc:mysql://localhost/likelion-db";
            String user = "root";
            String pw = "12345";
            Connection c = DriverManager.getConnection(url, user, pw);

                PreparedStatement ps = c.prepareStatement(
                        "insert into usertable(id,password,name) values(?,?,?)");
                ps.setInt(1, dao.getId());
                ps.setString(2, dao.getPassword());
                ps.setString(3, dao.getName());
                ps.executeUpdate();
                ps.setInt(1,1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public UserDAO(){

    }
    public void search(){
        try {
            String url = "jdbc:mysql://localhost/likelion-db";
            String user = "root";
            String pw = "12345";
            Connection c = DriverManager.getConnection(url, user, pw);
            String sql = "select * from usertable";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<UserDAO> list = new ArrayList<>();
            while (rs.next()){
                UserDAO dao = new UserDAO();
                dao.setId(rs.getInt("id"));
                dao.setPassword(rs.getString("password"));
                dao.setName(rs.getString("name"));
                list.add(dao);
            }
            for(UserDAO temp : list){
                System.out.println(temp.getId());
                System.out.println(temp.getPassword());
                System.out.println(temp.getName());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
