package org.example;
public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, Author author, String fileFormat) {
        super(title, author);
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}