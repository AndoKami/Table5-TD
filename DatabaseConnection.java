package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String url;
    private String username;
    private String password;

    public DatabaseConnection() {
        this.url = PostgreSqlConf.url;
        this.username = PostgreSqlConf.user;
        this.password = PostgreSqlConf.password;
    }


    public Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    this.url,
                    this.username,
                    this.password
            );
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.createConnection();
    }
}
