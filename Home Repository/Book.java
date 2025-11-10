//************************************************************************************
// 5.7
// Design and implement a class called Book that contains instance
// data for the title, author, publisher, and copyright date. Define the
// Book constructor to accept and initialize these data. Include set-
// ter and getter methods for all instance data. Include a toString
// method that returns a nicely formatted, multiline description of
// the book. Create a driver class called Bookshelf, whose main
// method instantiates and updates several Book objects.
//************************************************************************************

public class Book{
    private String title, author, publisher, copyrightDate;

    public Book(String title, String author, String publisher, String copyrightDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copyrightDate = copyrightDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setCopyrightDate(String copyrightDate) {
        this.copyrightDate = copyrightDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCopyrightDate() {
        return copyrightDate;
    }

    public String toString() {
        return String.format("Title:     %-1s%nAuthor:    %-1s%nPublisher: %-1s%nCopyright: %-11s%n%n", title, author, publisher, copyrightDate);
    }


}