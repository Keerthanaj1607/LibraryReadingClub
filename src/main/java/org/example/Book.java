package org.example;

public class Book  implements  Readable{
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public void read() {
        System.out.println("Reading book: " + title);
    }

}
