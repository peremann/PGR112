package loesninger._06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private BookRegister bookRegister;
    private String userName;

    public void setBookRegister(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void run(){
        System.out.println("Welcome to the book register. Here are your options:");
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while(choice!=8){
            System.out.println("What do you choose, " + userName + "?");
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

    private void quit() {
        System.out.println("Bye!");
    }

    private void booksByAuthor() {
        System.out.println("Enter author:");Scanner scanner = new Scanner(System.in);
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
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn");
        String isbn = scanner.nextLine();
        book.setIsbn(isbn);
        System.out.println("Enter title");
        String title = scanner.nextLine();
        book.setTitle(title);
        System.out.println("Enter author");
        String author = scanner.nextLine();
        book.setAuthor(author);
        System.out.println("Enter number of pages");
        int nrOfPages = scanner.nextInt();
        scanner.nextLine(); // Swallowing line break
        book.setNumberOfPages(nrOfPages);
        System.out.println("Enter genre (CRIME, ACTION, FANTASY, CLASSIC, OTHER)");
        String genreAsText = scanner.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreAsText);
        book.setGenre(genre);
        System.out.println("Enter reading time per page");
        book.setMinutesPerPage(scanner.nextInt());
        scanner.nextLine(); // Swallowing line break
        System.out.println("Enter publication date (YYYY-MM-DD)");
        String publicationDate = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(publicationDate);
        book.setPublished(localDate);
        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean moreChapters = true;
        while(moreChapters){
            Chapter chapter = new Chapter();
            System.out.println("Enter chapter title");
            String chapterTitle = scanner.nextLine();
            chapter.setTitle(chapterTitle);
            System.out.println("Enter chapter number of pages");
            int chapterPages = scanner.nextInt();
            chapter.setNumberOfPages(chapterPages);
            scanner.nextLine(); // Swallowing line break
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
