package com.tms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    static Connection connection;
    static Statement statement;

    private static void connect() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myLibrary", "root", "7502456");
            statement = connection.createStatement();
            System.out.println("Подключились к БД");

        } catch (SQLException e) {
            throw new SQLException("Unable to connect.");
        } finally {
            disconnect();
        }
    }

    private static void disconnect() {
        try {
            statement.close();
            System.out.println("Отключились от БД");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}