package loesninger._16.book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private BookRegister bookRegister;

    public Program(BookRegister bookRegister) throws Exception {
        this.bookRegister = bookRegister;
    }

    public void setBookRegister(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
    }

    public void run() throws IOException {
        System.out.println(UserCommunication.WELCOME);
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while(choice!=8){
            System.out.println(UserCommunication.USER_CHOICE_PROMPT);
            System.out.println("1. Add book");
            System.out.println("2. All books");
            System.out.println("3. Books by genre");
            System.out.println("4. Books by maximum reading time");
            System.out.println("5. Remove book");
            System.out.println("6. Books by author");
            System.out.println("7. Books older than...");
            System.out.println("8. Quit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> allBooks();
                case 3 -> booksByGenre();
                case 4 -> booksByMaxReadingTime();
                case 5 -> removeBook();
                case 6 -> booksByAuthor();
                case 7 -> booksOlderThan();
                case 8 -> quit();
                default -> System.out.println("Your options are 1-8");
            }
        }
    }

    private void booksOlderThan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date (YYYY-MM-DD)");
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        bookRegister.booksOlderThan(localDate);
    }

    private void quit() throws IOException {
        System.out.println("Bye!");
        bookRegister.writeBooksTofile();

    }

    private void booksByAuthor() {
        System.out.println(UserCommunication.ENTER_AUTHOR);
        Scanner scanner = new Scanner(System.in);
        String author = scanner.nextLine();
        bookRegister.booksByAuthor(author);
    }

    private void removeBook() {
        System.out.println("Enter ISBN");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        bookRegister.removeBook(isbn);
    }

    private void booksByMaxReadingTime() {
        System.out.println("Enter max reading time in minutes:");
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        ArrayList<Book> books = bookRegister.booksByReadingTime(time);
        for (Book b :
                books) {
            System.out.println(b);
        }
    }

    private void booksByGenre() {
        System.out.println("What Genre?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(s);
        bookRegister.booksByGenre(genre);
    }

    private void allBooks() {
        bookRegister.allBooksInRegister();
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        boolean validIsbn = false;
        String isbn = null;
        while(!validIsbn){
            System.out.println("Enter isbn");
            isbn = scanner.nextLine();
            validIsbn = BookUtility.validISBN(isbn);
        }

        System.out.println("Enter title");
        String title = scanner.nextLine();
        System.out.println(UserCommunication.ENTER_AUTHOR);
        String author = scanner.nextLine();
        System.out.println("Enter number of pages");
        int nrOfPages = scanner.nextInt();
        scanner.nextLine(); // Swallowing line break
        System.out.println(UserCommunication.ENTER_GENRE);
        String genreAsText = scanner.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreAsText);
        System.out.println("Enter reading time per page");
        int minPerPage = scanner.nextInt();
        scanner.nextLine(); // Swallowing line break
        System.out.println("Enter publication date (YYYY-MM-DD)");
        String publicationDate = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(publicationDate);
        Book book = new Book(isbn, localDate, title, author, nrOfPages, genre, minPerPage);

        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean moreChapters = true;
        while(moreChapters){
            System.out.println("Enter chapter title");
            String chapterTitle = scanner.nextLine();
            System.out.println("Enter chapter number of pages");
            int chapterPages = scanner.nextInt();
            scanner.nextLine(); // Swallowing line break
            Chapter chapter = new Chapter(chapterTitle, chapterPages);
            chapters.add(chapter);
            System.out.println("More chapters? (y/n)");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("n")){
                moreChapters = false;
            }
        }
        book.setChapters(chapters);
        bookRegister.addBook(book);
    }
}
