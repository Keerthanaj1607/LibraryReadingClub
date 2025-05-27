package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
          }

    public List<Book> getBooks() {
        return books;
    }
}