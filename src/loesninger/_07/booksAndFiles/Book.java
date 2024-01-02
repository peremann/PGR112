package loesninger._07.booksAndFiles;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private LocalDate published;
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private ArrayList<Chapter> chapters;
    private int minutesPerPage;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
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
