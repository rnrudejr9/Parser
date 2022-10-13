package com.line.database;

import java.sql.*;

public class SQLtest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Dvrver is Loadded");
            String url = "jdbc:mysql://localhost:3306/mydb";
            String user = "root";
            String pass = "readfree1m";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student");
            System.out.println("No\t\tName\tHP");
            while (rs.next()) {
                System.out.print(rs.getString("NO") + "\t");
                System.out.print(rs.getString("NAME") + "\t");
                System.out.print(rs.getString("HP") + "\t");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
}

