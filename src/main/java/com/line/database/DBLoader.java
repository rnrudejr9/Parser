package com.line.database;


import com.line.domain.Hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBLoader {
    String url;
    String userName;
    String password;

    public DBLoader(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public void loadDatabase(List<Hospital> obj){
        try {
            String url = "jdbc:mysql://localhost/likelion-db";
            String user = "root";
            String pw = "12345";
            Connection c = DriverManager.getConnection(url, user, pw);
                for (Hospital p : obj) {
                    PreparedStatement ps = c.prepareStatement(
                            "insert into new_table(id,address,district,category,emergency_room,name,subdivision) values(?,?,?,?,?,?,?)");
                    ps.setString(1, p.getId());
                    ps.setString(2, p.getAdress());
                    ps.setString(3, p.getDistrict());
                    ps.setString(4, p.getCategory());
                    ps.setInt(5, p.getEmergencyRoom());
                    ps.setString(6, p.getName());
                    ps.setString(7, p.getSubdivision());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void readDatabase(){
        try {
            String url = "jdbc:mysql://localhost/likelion-db";
            String user = "root";
            String pw = "12345";
            Connection c = DriverManager.getConnection(url, user, pw);
            String sql = "select * from new_table";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Hospital> list = new ArrayList<>();
            while (rs.next()){
                Hospital temp = new Hospital();
                temp.setId(rs.getString("id"));
                temp.setAdress(rs.getString("address"));
                temp.setDistrict(rs.getString("district"));
                temp.setCategory(rs.getString("category"));
                temp.setEmergencyRoom(rs.getInt("emergency_room"));
                temp.setName(rs.getString("name"));
                temp.setSubdivision(rs.getString("subdivision"));
                list.add(temp);
            }

            for(Hospital p : list){
                p.print();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
