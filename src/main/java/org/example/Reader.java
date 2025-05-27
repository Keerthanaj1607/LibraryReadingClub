package org.example;

public class Reader {
    private String name;
    public Reader(String name){
        this.name= name;
    }
    public void readBook(Book book){
        System.out.println(name+"is reading"+book.getTitle());
        book.read();
    }

    public String getName() {
        return name;
    }
}
