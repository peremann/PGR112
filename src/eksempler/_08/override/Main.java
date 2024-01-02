package eksempler._08.override;

public class Main {
    public static void main(String[] args) {
        Chapter chapter = new Chapter();
        chapter.setTitle("Det var en gang...");
        chapter.setNumberOfPages(12);
        System.out.println(chapter.toString());
    }
}
