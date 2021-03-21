package com.tms.db;

import com.tms.library.Book;

import java.sql.*;


public class DbConnectionExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "7502456");

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from books");

        while (rs.next()) {
            Book book = Book.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .author(rs.getInt(3))
                    .isbn(rs.getString(4))
                    .build();
            System.out.println(book);


        }


    }
}
