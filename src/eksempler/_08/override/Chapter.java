package eksempler._08.override;

public class Chapter {
    private String title;
    private int numberOfPages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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
