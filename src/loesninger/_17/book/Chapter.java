package loesninger._17.book;

public class Chapter {
    private final String title;
    private final int numberOfPages;

    public Chapter(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }


    @Override
    public String toString() {
        return String.format("Chapter{title='%s', numberOfPages=%d}", title, numberOfPages);
    }


    public String toFileFormat() {
        return String.format("%s%n%d%n", title, numberOfPages);
    }
}
