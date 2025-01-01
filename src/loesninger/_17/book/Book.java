package loesninger._17.book;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private final String isbn;
    private final LocalDate published;
    private final String title;
    private final String author;
    private final int numberOfPages;
    private final Genre genre;
    private List<Chapter> chapters;
    private final int minutesPerPage;

    public Book(String isbn, LocalDate published, String title, String author, int numberOfPages, Genre genre, int minutesPerPage) {
        this.isbn = isbn;
        this.published = published;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.minutesPerPage = minutesPerPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublished() {
        return published;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public int readingTime(){
        return numberOfPages*minutesPerPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", published=" + published +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", genre=" + genre +
                ", chapters=" + chapters +
                ", minutesPerPage=" + minutesPerPage +
                '}';
    }

    public String toFileFormat(){
        StringBuilder s = new StringBuilder(isbn + '\n' +
                published + '\n' +
                title + '\n' +
                author + '\n' +
                numberOfPages + '\n' +
                genre + '\n' +
                minutesPerPage + '\n' +
                chapters.size() + '\n');
        for (Chapter c :
                chapters) {
            s.append(c.toFileFormat());
        }
        return s.toString();
    }
}
