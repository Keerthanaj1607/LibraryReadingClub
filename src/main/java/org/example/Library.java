package org.example;

import java.util.ArrayList;
import java.util.Iterator;
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

    // ✅ This method MUST be here — inside Library class
    public boolean deleteBookByTitle(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().trim().equalsIgnoreCase(title.trim())) {
                iterator.remove();
                return true; // Book deleted
            }
        }
        return false; // Book not found
    }
}
