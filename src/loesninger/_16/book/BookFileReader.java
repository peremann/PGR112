package loesninger._16.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookFileReader implements BookProvider{
    @Override
    public List<Book> retrieveBooks() throws FileNotFoundException {
        ArrayList<Book> booksFromFile = new ArrayList<>();
        File file = new File("files/books.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String isbn = scanner.nextLine();
            String publishedDate = scanner.nextLine();
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            String nrOfPages = scanner.nextLine();
            String genre = scanner.nextLine();
            String minutesPerPage = scanner.nextLine();
            String numberOfChapters = scanner.nextLine();
            int nrChapters = Integer.parseInt(numberOfChapters);
            Book b = new Book(isbn, LocalDate.parse(publishedDate), title, author, Integer.parseInt(nrOfPages), Genre.valueOf(genre), Integer.parseInt(minutesPerPage));
            ArrayList<Chapter> chapters = new ArrayList<>();
            for (int i=0;i<nrChapters;i++){
                String chapterTitle = scanner.nextLine();
                String chapterPages = scanner.nextLine();
                int cPages = Integer.parseInt(chapterPages);
                Chapter c = new Chapter(chapterTitle, cPages);
                chapters.add(c);
            }
            b.setChapters(chapters);
            booksFromFile.add(b);
            scanner.nextLine();
        }
        return booksFromFile;
    }
}
