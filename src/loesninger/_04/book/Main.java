package loesninger._04.book;

public class Main {
    public static void main(String[] args) {
        Book b = new Book();
        b.setAuthor("Knut Hamsun");
        b.setTitle("Sult");
        b.setNumberOfPages(111);
        b.setGenre(Genre.CLASSIC);
        b.printMe();
    }
}
