package com.line.database;


import com.line.domain.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(this.url, this.userName, this.password);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from `likelion-db`");
//
//            while(rs.next()){
//                String name = rs.getString("id");
//                System.out.println(name);
//            }
//
//            rs.close();
//            st.close();
//            con.close();
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

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
}
