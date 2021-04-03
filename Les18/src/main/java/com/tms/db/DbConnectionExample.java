package com.tms.db;

import com.tms.library.Book;
import com.tms.library.Author;

import java.sql.*;
import java.util.*;


public class DbConnectionExample {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "7502456")) {
            System.out.println("Choose way to fetch books: \n 1. Fast way (press '1') \n 2. Regular way (press '2'");
            int option = sc.nextInt();
            System.out.println("1. Добавить книгу\n" +
                    "2. Отредактировать книгу\n" +
                    "3. Удалить книгу\n" +
                    "4. Вывести список всех книг\n" +
                    "5. Вывести список книг определенного автора/жанра\n" +
                    "6. Вывести список книг по алфавиту\n");



            if (option == 1) {
                fetchAllBooksInAFastWay(conn);
                //  updateLastBook(conn);
                //fetchAllBooksInAFastWay(conn);
                //deleteLastModifiedBook(conn);
            } else {
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
                        authors.add(fetchAuthor(resultSet.getInt("author_id"), conn));
                    }

                    Book book = builder.authors(authors)
                            .build();

                    System.out.println(book);
                }
                if (statement != null) {
                    statement.close();
                    System.err.println("Statement close");
                } else {
                    System.err.println("Statement не создан");
                }
                if (conn != null) {
                    try {
                        conn.close();
                        System.err.println("Сonnection close.");
                    } catch (SQLException e) {
                        System.err.println("Сonnection close error: " + e);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Author fetchAuthor(int authorId, Connection conn) throws SQLException {
       // System.out.println(authorId + " " + conn);
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

        Author author = Author.builder()
                .id(rs.getInt(1))
                .firstName(rs.getString(2))
                .lastName(rs.getString(3))
                .build();
        return author;
    }


    private static void fetchAllBooksInAFastWay(Connection conn) throws SQLException {
        String sql = "select b.id, b.name, b.genre, b.ISBN, a.id, a.first_name, a.last_name " +
                "from books b " +
                "    left join book_author ba on b.id = ba.book_id " +
                "    left join authors a on a.id = ba.author_id";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        Map<Book, List<Author>> books = new HashMap<>();


        while (rs.next()) {
            int bookId = rs.getInt(1);
            Optional<Book> bookOptional = books.keySet().stream().filter(book -> book.getId() == bookId).findFirst();
            bookOptional.ifPresent(book -> book.getAuthors().add(buildAuthor(rs)));
            Book book = Book.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .genre((rs.getString(3)))
                    .isbn(rs.getString(4))
                    .authors(new ArrayList<>(Arrays.asList(buildAuthor(rs))))
                    .build();
            books.put(book, book.getAuthors());


        }
        System.out.println(books.keySet());

    }

    private static Author buildAuthor(ResultSet rs) {
        try {
            return Author.builder()
                    .id(rs.getInt(5))
                    .firstName(rs.getString(6))
                    .lastName(rs.getString(7))

                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Author.builder().build();

    }

}
