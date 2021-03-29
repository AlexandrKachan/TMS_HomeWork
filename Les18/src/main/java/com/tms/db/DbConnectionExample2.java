package com.tms.db;

import com.tms.library.Author;
import com.tms.library.Book;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.util.*;

public class DbConnectionExample2 {
    private static Scanner sc = new Scanner(System.in);
    private static Integer lastInsertedBookId;

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "7502456")) {

            System.out.println("Choose way to fetch books: \n 1. Fast way (press '1') \n 2. Regular way (press '2'");
            int option = sc.nextInt();
//            System.out.println("1. Добавить книгу\n" +
//                    "2. Отредактировать книгу\n" +
//                    "3. Удалить книгу\n" +
//                    "4. Вывести список всех книг\n" +
//                    "5. Вывести список книг определенного автора/жанра\n" +
//                    "6. Вывести список книг по алфавиту\n");
//
//            //insertNewBookAndAuthor(conn);
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
                        authors.add(fetchAuthor(resultSet.getInt(1), conn));
                    }

                    Book book = builder.authors(authors)
                            .build();

                    System.out.println(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteLastModifiedBook(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from book_author where book_id = ?");
        ps.setInt(1, lastInsertedBookId);
        ps.executeUpdate();

        ps = conn.prepareStatement("delete from books where id = ?");
        ps.setInt(1, lastInsertedBookId);
        ps.executeUpdate();
    }

    private static void insertNewBookAndAuthor(Connection conn) throws SQLException {
        final String authFirstName = RandomStringUtils.randomAlphabetic(5);
        final String authLastName = RandomStringUtils.randomAlphabetic(10);
        final String bookName = RandomStringUtils.randomAlphabetic(5);
        final String bookGenre = RandomStringUtils.randomAlphabetic(5);
        final String bookISBN = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
        String sqlInsertAuthor = "insert into authors (first_name, last_name) values (?, ?)";
        String sqlInsertBook = "insert into books (name, genre, isbn) values (?, ?, ?)";
        String sqlInsertBookAuthor = "insert into book_author (book_id, author_id) values (?, ?)";
        PreparedStatement psForConnectionTable = conn.prepareStatement(sqlInsertBookAuthor);

        PreparedStatement ps = conn.prepareStatement(sqlInsertAuthor, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, authFirstName);
        ps.setString(2, authLastName);
        ps.executeUpdate();
        int authorId;
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            authorId = rs.getInt(1);
            psForConnectionTable.setInt(2, authorId);
        }

        ps = conn.prepareStatement(sqlInsertBook, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, bookName);
        ps.setString(2, bookGenre);
        ps.setString(3, bookISBN);
        ps.executeUpdate();
        int bookId;
        rs = ps.getGeneratedKeys();
        if (rs.next()) {
            bookId = rs.getInt(1);
            psForConnectionTable.setInt(1, bookId);
            lastInsertedBookId = bookId;
        }

        psForConnectionTable.execute();
    }

    private static void updateLastBook(Connection conn) throws SQLException {
        if (lastInsertedBookId != null) {

            String query = "update books set name = 'UPD NAME' where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, lastInsertedBookId);
            ps.executeUpdate();
        } else {
            System.out.println("Last book id is null");
        }
    }


    private static Author fetchAuthor(int authorId, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from authors where id = ?");

        ps.setInt(1, authorId);

        ResultSet rs = ps.executeQuery();
        List<Author> authors = createAuthors(rs);
        //System.out.println(authors);
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


    private static void fetchAllBooksInAFastWay(Connection conn) throws SQLException {
        String sql = "select b.id, b.name, b.genre, b.ISBN, a.id, a.first_name, a.last_name " +
                "from books b " +
                "    left join book_author ba on b.id = ba.book_id " +
                "    left join authors a on a.id = ba.author_id";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        Map<Book, List<Author>> books = new HashMap<>();
        while (rs.next()) {
            int bookId = rs.getInt(1);

            Optional<Book> bookOpt = books.keySet().stream().filter(book -> book.getId() == bookId).findFirst();
            bookOpt.ifPresent(book -> book.getAuthors().add(buildAuthor(rs)));
            System.out.println();
            Book book = Book.builder()
                    .id(bookId)
                    .name(rs.getString(2))
                    .genre(rs.getString(3))
                    .isbn(rs.getString(4))
                    .authors(new ArrayList<>(Arrays.asList(buildAuthor(rs))))
                    .build();
            books.put(book, book.getAuthors());
        }
        System.out.println(books.keySet() );

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