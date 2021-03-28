package com.tms.db;

import com.tms.library.Book;
import com.tms.library.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbConnectionExample {
    public static void main(String[] args) {

        // Class.forName("com.mysql.cj.Driver");

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    "root",
                    "7502456");
            {
            }

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("select * from books");


            while (rs.next()) {
                Book.BookBuilder builder = Book.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .genre(rs.getString(3))
                        .isbn(rs.getString(4));


                PreparedStatement ps = conn.prepareStatement("select * from book_author where book_id = ?");
                ps.setInt(1, rs.getInt(1));
                ResultSet resultSet = ps.executeQuery();
                List<Author> authors = new ArrayList<>();
                while (resultSet.next()) {
                    authors.add(fetchAuthor(rs.getInt(1), conn));
                }

                Book book = builder.authors(authors)
                        .build();




                System.out.println(book);
            }
            statement.close();
            rs.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }


    }


    private static Author fetchAuthor(int authorId, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from  authors where id = ?");
        ps.setInt(1, authorId);
        ResultSet rs = ps.executeQuery();
        List<Author> authors = createAuthors(rs);
        return !authors.isEmpty() ? authors.get(0) : null;
    }


    private static List<Author> createAuthors(ResultSet rs) throws SQLException {
        List<Author> authors = new ArrayList<>();
        while (rs.next()) {
            authors.add(createAuthor(rs));
        }
        return authors;
    }


    private static Author createAuthor(ResultSet rs) throws SQLException {

        Author a = Author.builder()
                .id(rs.getInt(1))
                .firstName(rs.getString(2))
                .lastName(rs.getString(3))

                .build();
        return a;
    }

}
