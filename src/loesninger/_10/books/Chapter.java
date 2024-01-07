package loesninger._10.books;

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
        return "Chapter{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    public String toFileFormat() {
        return title + '\n' +
                numberOfPages + '\n';
    }
}
