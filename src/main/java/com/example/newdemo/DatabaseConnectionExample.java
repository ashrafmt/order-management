package com.example.newdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionExample {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/newdemo";
        String username = "root";
        String password = "";

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Perform a database operation
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stock");

            // Process the result
            while (resultSet.next()) {
                // Retrieve data from the result set
                // Example: String columnName = resultSet.getString("column_name");
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}