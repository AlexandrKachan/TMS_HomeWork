package com.tms.db;

import com.tms.library.Book;
import com.tms.library.Author;

import java.sql.*;


public class DbConnectionExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       // Class.forName("com.mysql.cj.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "7502456");

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from books");
       // System.out.println(rs.getString(2));

        while (rs.next()) {
            Book book = Book.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .author(rs.getInt(3))
                    .isbn(rs.getString(4))
                    .build();
            System.out.println(book);
        }

        ResultSet rs2 = statement.executeQuery("select * from authors");
        while (rs2.next()) {
            Author author = Author.builder()
                    .id(rs2.getInt(1))
                    .first_name(rs2.getString(2))
                    .last_name(rs2.getString(3))
                    .build();
            System.out.println(author);


        }





    }
}
