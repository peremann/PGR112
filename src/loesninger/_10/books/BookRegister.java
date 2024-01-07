package loesninger._10.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {
    private ArrayList<Book> books;

    public BookRegister() throws FileNotFoundException {
        books = readBooksFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        for (Book b :
                books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(b);
                return;
            }
        }
    }

    public int numberOfBooks() {
        return books.size();
    }

    public void allBooksInRegister() {
        for (Book b :
                books) {
            System.out.println(b.toString());
        }
    }

    public void booksByGenre(Genre genre) {
        for (Book b :
                books) {
            if (b.getGenre() == genre) {
                System.out.println(b.toString());
            }
        }
    }

    public void booksByAuthor(String author) {
        for (Book b :
                books) {
            if (b.getAuthor().equals(author)) {
                System.out.println(b.toString());
            }
        }
    }

    public ArrayList<Book> booksByReadingTime(int minutes) {
        ArrayList<Book> booksToReturn = new ArrayList<>();
        for (Book b :
                books) {
            if (b.readingTime() <= minutes) {
                booksToReturn.add(b);
            }
        }
        return booksToReturn;
    }

    private ArrayList<Book> readBooksFromFile() throws FileNotFoundException {
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

    public void booksOlderThan(LocalDate localDate) {
        for (Book b :
                books) {
            if (b.getPublished().isBefore(localDate)) {
                System.out.println(b.toString());
            }
        }
    }

    public void writeBooksTofile() throws IOException {
        File file = new File("files/books.txt");
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file);) {
            for (Book b :
                    books) {
                writer.write(b.toFileFormat());
                writer.write("---\n");
            }
        }
    }
}
