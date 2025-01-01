package loesninger._17.book;


public class Main {
    public static void main(String[] args) {
        try {
            //BookRegister bookRegister = new BookRegister(new BookService());
            BookRegister bookRegister = new BookRegister(new BookFileReader());
            new Program(bookRegister).run();
        } catch (Exception e) {
            System.out.println("Unable to ready/write from/to file:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
