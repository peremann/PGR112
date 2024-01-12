package loesninger._05;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookRegister br = new BookRegister();
        Book b1 = new Book();
        b1.setTitle("Sult");
        b1.setGenre(Genre.CLASSIC);
        b1.setAuthor("Knut Hamsun");
        b1.setNumberOfPages(111);
        b1.setChapters(new ArrayList<Chapter>());
        br.addBook(b1);

        Book b2 = new Book();
        b2.setTitle("Victoria");
        b2.setGenre(Genre.CLASSIC);
        b2.setAuthor("Knut Hamsun");
        b2.setNumberOfPages(75);
        Chapter chapter1 = new Chapter();
        chapter1.setTitle("Title1");
        chapter1.setNumberOfPages(20);
        chapter1.setReadingTime(4);
        Chapter chapter2 = new Chapter();
        chapter2.setTitle("Title2");
        chapter2.setNumberOfPages(25);
        chapter2.setReadingTime(5);
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);
        chapters.add(chapter2);
        b2.setChapters(chapters);
        br.addBook(b2);

        System.out.println("Number of books in register:"+br.numberOfBooks());
        br.allBooksInRegister();
        br.booksByGenre(Genre.CLASSIC);
        System.out.println("Testing by FANTASY");
        br.booksByGenre(Genre.FANTASY);
        System.out.println("Books by Hamsun:");
        br.booksByAuthor("Knut Hamsun");
        System.out.println("Books by blabla:");
        br.booksByAuthor("blabla");

        System.out.println("By reading time 3");
        ArrayList<Book> books = br.booksByReadingTime(3);
        for (Book b :
                books) {
            System.out.println(b);
        }
    }
}
