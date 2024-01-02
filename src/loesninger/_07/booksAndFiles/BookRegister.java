package loesninger._07.booksAndFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {
    private ArrayList<Book> books;

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

    public void initRegister() throws FileNotFoundException {
        books = readBooksFromFile();
    }

    private ArrayList<Book> readBooksFromFile() throws FileNotFoundException {
        ArrayList<Book> booksFromFile = new ArrayList<>();
        File file = new File("files/books.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            Book b = new Book();
            String isbn = scanner.nextLine();
            b.setIsbn(isbn);
            String publishedDate = scanner.nextLine();
            b.setPublished(LocalDate.parse(publishedDate));
            b.setTitle(scanner.nextLine());
            String author = scanner.nextLine();
            b.setAuthor(author);
            String nrOfPages = scanner.nextLine();
            b.setNumberOfPages(Integer.parseInt(nrOfPages));
            String genre = scanner.nextLine();
            b.setGenre(Genre.valueOf(genre));
            String minutesPerPage = scanner.nextLine();
            b.setMinutesPerPage(Integer.parseInt(minutesPerPage));
            String numberOfChapters = scanner.nextLine();
            int nrChapters = Integer.parseInt(numberOfChapters);
            ArrayList<Chapter> chapters = new ArrayList<>();
            for (int i=0;i<nrChapters;i++){
                Chapter c = new Chapter();
                String chapterTitle = scanner.nextLine();
                c.setTitle(chapterTitle);
                String chapterPages = scanner.nextLine();
                c.setNumberOfPages(Integer.parseInt(chapterPages));
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
