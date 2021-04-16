package com.tms;

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    static Connection connection;
    static Statement statement;
    private static Scanner sc = new Scanner(System.in);
//    private static Integer lastInsertedBookId;

    public static void main(String[] args) throws SQLException {
//        try {
//            // connect();
//            System.out.println("1. Добавить книгу\n" +  //insertNewBookAndAuthor(conn);
//                    "2. Отредактировать книгу\n" +  //  updateLastBook(conn);
//                    "3. Удалить книгу\n" +           //deleteLastModifiedBook(conn);
//                    "4. Вывести список всех книг\n" +
//                    "5. Вывести список книг определенного автора/жанра\n" +
//                    "6. Вывести список книг по алфавиту\n");
//            int option = sc.nextInt();
//
//            if (option == 1) {
//                insertNewBookAndAuthor(connection);
//                // fetchAllBooksInAFastWay(conn);
//            } else if (option == 2) {
//                //  updateLastBook(connection);
//            } else if (option == 3) {
//                //  deleteLastModifiedBook(connection);
//            } else if (option == 4) {
//                fetchAllBooks(connection, statement);
//            } else {
//                System.out.println("Программа завершена");
//            }
//
//            //  insertNewBookAndAuthor(connection);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        System.out.println("Программа завершена");
    }

//}


//    // Подключаемся ********************************************************
//    private static void connect() throws SQLException {
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myLibrary", "root", "7502456");
//            statement = connection.createStatement();
//            System.out.println("Подключились к БД");
//
//        } catch (SQLException e) {
//            throw new SQLException("Unable to connect.");
//        } finally {
//            disconnect();
//        }
//    }
//
//    // Отключаемся ************************************************************************************************
//    private static void disconnect() {
//        try {
//            statement.close();
//            System.out.println("Отключились от БД");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    // Выводим все книги **********************************************************************************************
    private static void fetchAllBooks(Connection connection, Statement statement) {

        try {
            Connect();
            try {
                ResultSet rs = statement.executeQuery("SELECT * FROM books;");

                while (rs.next()) {
                    //System.out.println(rs.getInt(1) + "  " + rs.getString("name") + " "
                    //      + rs.getString(3) + " " + rs.getString("isbn"));
                    System.out.println(rs.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // disconnect();
        }

//        while (rs.next()) {
//            Book.BookBuilder builder = Book.builder()
//                    .id(rs.getInt(1))
//                    .name(rs.getString(2))
//                    .genre(rs.getString(3))
//                    .isbn(rs.getString(4));
//
//            PreparedStatement ps = connection.prepareStatement("select * from book_author where book_id = ?");
//            ps.setInt(1, rs.getInt(1));
//            ResultSet resultSet = ps.executeQuery();
//
//
//            List<Author> authors = new ArrayList<>();
//
//            while (resultSet.next()) {
//                authors.add(fetchAuthor(resultSet.getInt(1), connection));
//            }
//
//            Book book = builder.authors(authors)
//                    .build();
//
//            System.out.println(book);
//        }

//    }
//// Вставляем книгу **********************************************************************************************
//
//    private static void insertNewBookAndAuthor(Connection connection) throws SQLException {
//
//        final String authFirstName = RandomStringUtils.randomAlphabetic(5);
//        final String authLastName = RandomStringUtils.randomAlphabetic(10);
//        final String bookName = RandomStringUtils.randomAlphabetic(5);
//        final String bookGenre = RandomStringUtils.randomAlphabetic(5);
//        final String bookISBN = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
//        String sqlInsertAuthor = "insert into authors (first_name, last_name) values (?, ?)";
//        String sqlInsertBook = "insert into books (name, genre, isbn) values (?, ?, ?)";
//        String sqlInsertBookAuthor = "insert into book_author (book_id, author_id) values (?, ?)";
//        PreparedStatement psForConnectionTable = connection.prepareStatement(sqlInsertBookAuthor);
//
//        PreparedStatement ps = connection.prepareStatement(sqlInsertAuthor, Statement.RETURN_GENERATED_KEYS);
//        ps.setString(1, authFirstName);
//        ps.setString(2, authLastName);
//        ps.executeUpdate();
//        int authorId;
//        ResultSet rs = ps.getGeneratedKeys();
//        if (rs.next()) {
//            authorId = rs.getInt(1);
//            psForConnectionTable.setInt(2, authorId);
//        }
//
//        ps = connection.prepareStatement(sqlInsertBook, Statement.RETURN_GENERATED_KEYS);
//        ps.setString(1, bookName);
//        ps.setString(2, bookGenre);
//        ps.setString(3, bookISBN);
//        ps.executeUpdate();
//        int bookId;
//        rs = ps.getGeneratedKeys();
//        if (rs.next()) {
//            bookId = rs.getInt(1);
//            psForConnectionTable.setInt(1, bookId);
//            //lastInsertedBookId = bookId;
//        }
//
//        psForConnectionTable.execute();
//    }
//

//    private static Author fetchAuthor(int authorId, Connection conn) throws SQLException {
//        PreparedStatement ps = conn.prepareStatement("select * from authors where id = ?");
//
//        ps.setInt(1, authorId);
//
//        ResultSet rs = ps.executeQuery();
//        List<Author> authors = createAuthors(rs);
//        //System.out.println(authors);
//        return !authors.isEmpty() ? authors.get(0) : null;
//    }

//    private static List<Author> createAuthors(ResultSet rs) throws SQLException {
//        List<Author> authors = new ArrayList<>();
//        while (rs.next()) {
//            authors.add(createAuthor(rs));
//        }
//        return authors;
//    }
//
//    private static Author createAuthor(ResultSet rs) throws SQLException {
//        Author a = Author.builder()
//                .id(rs.getInt(1))
//                .firstName(rs.getString(2))
//                .lastName(rs.getString(3))
//                .build();
//        return a;
//    }
//
//    private static void updateLastBook(Connection conn) throws SQLException {
//        if (lastInsertedBookId != null) {
//
//            String query = "update books set name = 'UPD NAME' where id = ?";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setInt(1, lastInsertedBookId);
//            ps.executeUpdate();
//        } else {
//            System.out.println("Last book id is null");
//        }
//    }
//
//    private static void deleteLastModifiedBook(Connection conn) throws SQLException {
//        PreparedStatement ps = conn.prepareStatement("delete from book_author where book_id = ?");
//        ps.setInt(1, lastInsertedBookId);
//        ps.executeUpdate();
//
//        ps = conn.prepareStatement("delete from books where id = ?");
//        ps.setInt(1, lastInsertedBookId);
//        ps.executeUpdate();
//    }
//

