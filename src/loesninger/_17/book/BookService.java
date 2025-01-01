package loesninger._17.book;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookProvider{
    private final MysqlDataSource bookDS;

    private static final String GET_ALL_BOOKS_SQL = "SELECT isbn, published, title, author, numberOfPages, genre, minutesPerPage FROM Book";
    private static final String GET_ALL_CHAPTERS_FOR_BOOK_SQL = "SELECT id, book_isbn, title, numberOfPages FROM Chapter WHERE book_isbn = ?";

    public BookService(){
        bookDS = new MysqlDataSource();
        bookDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        bookDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        bookDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        bookDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        bookDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));

    }

    @Override
    public List<Book> retrieveBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        try (Connection conn = bookDS.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_BOOKS_SQL)
        ) {
            while (rs.next()) {
                String isbn = rs.getString("isbn");
                LocalDate published = rs.getDate("published").toLocalDate();
                String title = rs.getString("title");
                String author = rs.getString("author");
                int numberOfPages = rs.getInt("numberOfPages");
                Genre genre = Genre.valueOf(rs.getString("genre"));
                int minutesPerPage = rs.getInt("minutesPerPage");
                Book book = new Book(isbn, published, title, author, numberOfPages, genre,minutesPerPage);
                book.setChapters(getChaptersForBook(isbn));
                books.add(book);
            }
        }
        return books;
    }

    private List<Chapter> getChaptersForBook(String isbn) throws SQLException {
        List<Chapter> chapters = new ArrayList<>();
        try (Connection conn = bookDS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_CHAPTERS_FOR_BOOK_SQL)
        ) {
            stmt.setString(1, isbn);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String book_isbn = rs.getString("book_isbn");
                    String title = rs.getString("title");
                    int numberOfPages = rs.getInt("numberOfPages");
                    chapters.add(new Chapter(title, numberOfPages));
                }
            }
        }
        return chapters;
    }
}
