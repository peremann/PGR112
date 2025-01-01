package loesninger._17.book;

import java.util.List;

public interface BookProvider {
    List<Book> retrieveBooks() throws Exception;
}
