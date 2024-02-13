package loesninger._16.book;

public class BookUtility {

    private BookUtility(){}
    public static boolean validISBN(String isbn){
        return isbn.length() == 10;
    }
}
