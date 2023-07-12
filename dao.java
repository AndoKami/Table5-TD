package com.todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dao {


    public String insertTodo(String title, Date deadline, int priority, boolean done, String description) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.createConnection();
        try {
            String sql = "INSERT INTO todo(title, deadline, priority, done) VALUES ('" + title + "', '" + deadline + "', " + priority + ", " + done + ", '" + description + "');";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return "Todo insert succefuly.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Todo is not valid or already exist.";
    }

    public String deleteTodo(int id) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.createConnection();
        try {
            String sql = "DELETE FROM todo WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return "Todo delete succefuly.";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "id = " + id + " not exist.";
    }

    public String updateTodo(int id, String newTitle, Date newDeadline, int newPriority, String newDescription) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.createConnection();
        try {
            String sql =
                    "UPDATE todo SET title = '" + newTitle + "';" +
                    "UPDATE todo SET deadline = '" + newDeadline + "';" +
                    "UPDATE todo SET priority = " + newPriority + ";" +
                    "UPDATE todo SET description = '" + newDescription + "';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return "Todo update succefuly.";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "id = " + id + " not exist or invalid values.";
    }

    public Todo showSpecificTodo(int id) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.createConnection();
        try {
            String sql = "SELECT * FROM todo WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("deadline"),
                        resultSet.getInt("priority"),
                        resultSet.getBoolean("done"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Todo> showAllTodo() {
        List<Todo> todoList = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.createConnection();
        try {
            String sql = "SELECT * FROM todo;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                todoList.add(
                        new Todo(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getDate("deadline"),
                                resultSet.getInt("priority"),
                                resultSet.getBoolean("done"),
                                resultSet.getString("description")
                        )
                );
            }
            return todoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}