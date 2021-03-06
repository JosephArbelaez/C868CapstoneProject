package com.example.C868CapstoneProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String url = "jdbc:postgresql://c868.chn9suhtp3tc.us-east-2.rds.amazonaws.com:5432/C868";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
