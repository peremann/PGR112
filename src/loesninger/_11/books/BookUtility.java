package loesninger._11.books;

public class BookUtility {

    private BookUtility(){}
    public static boolean validISBN(String isbn){
        return isbn.length() == 10;
    }
}
