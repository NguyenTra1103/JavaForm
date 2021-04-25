package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;instance= ADMIN\\SQLEXPRESS;;databasename= QLX";
        String username = "sa";
        String password ="1103";
        Connection connection = DriverManager.getConnection(connectionUrl,"sa","1103");

        return connection;
    }
}
