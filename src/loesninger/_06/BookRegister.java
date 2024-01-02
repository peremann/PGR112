package loesninger._06;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookRegister {
    private ArrayList<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(String isbn){
        for (Book b :
                books) {
            if(b.getIsbn().equalsIgnoreCase(isbn)){
                books.remove(b);
                return;
            }
        }
    }

    public int numberOfBooks(){
        return books.size();
    }

    public void allBooksInRegister(){
        for (Book b :
                books) {
            System.out.println(b.toString());
        }
    }

    public void booksByGenre(Genre genre){
        for (Book b :
                books) {
            if(b.getGenre() == genre){
                System.out.println(b.toString());
            }
        }
    }

    public void booksByAuthor(String author){
        for (Book b :
                books) {
            if(b.getAuthor().equals(author)){
                System.out.println(b.toString());
            }
        }
    }

    public ArrayList<Book> booksByReadingTime(int minutes){
        ArrayList<Book> booksToReturn = new ArrayList<>();
        for (Book b :
                books) {
            if(b.readingTime()<=minutes){
                booksToReturn.add(b);
            }
        }
        return booksToReturn;
    }

    public void initRegister(){
        books = new ArrayList<>();
        Book b1 = new Book();
        b1.setTitle("Sult");
        b1.setPublished(LocalDate.of(1890, 2, 12));
        b1.setGenre(Genre.CLASSIC);
        b1.setAuthor("Knut Hamsun");
        b1.setNumberOfPages(111);
        b1.setIsbn("12345");
        b1.setMinutesPerPage(3);
        ArrayList<Chapter> sultChapters = new ArrayList<>();
        Chapter sultChapter1 = new Chapter();
        sultChapter1.setTitle("En fin dag");
        sultChapter1.setNumberOfPages(23);
        sultChapters.add(sultChapter1);
        Chapter sultChapter2 = new Chapter();
        sultChapter2.setTitle("En enda finere dag");
        sultChapter2.setNumberOfPages(34);
        sultChapters.add(sultChapter2);
        b1.setChapters(sultChapters);
        addBook(b1);


        Book b2 = new Book();
        b2.setIsbn("23456");
        b2.setTitle("Victoria");
        b2.setPublished(LocalDate.of(1902, 3, 1));
        b2.setGenre(Genre.CLASSIC);
        b2.setAuthor("Knut Hamsun");
        b2.setNumberOfPages(75);
        b2.setMinutesPerPage(4);
        Chapter chapter1 = new Chapter();
        chapter1.setTitle("Title1");
        chapter1.setNumberOfPages(20);
        Chapter chapter2 = new Chapter();
        chapter2.setTitle("Title2");
        chapter2.setNumberOfPages(25);
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);
        chapters.add(chapter2);
        b2.setChapters(chapters);
        addBook(b2);
    }

    public void booksOlderThan(LocalDate localDate) {
        for (Book b :
                books) {
            if(b.getPublished().isBefore(localDate)){
                System.out.println(b.toString());
            }
        }
    }
}
