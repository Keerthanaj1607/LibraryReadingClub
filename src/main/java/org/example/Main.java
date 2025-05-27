package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library("Interactive Library");
        ReadingClub club = new ReadingClub("Interactive Reading Club");
        Map<String, Reader> readerMap = new HashMap<>(); // To track readers by name

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Add Reader");
            System.out.println("4. Reader Reads Book");
            System.out.println("5. View Reading Club Members");
            System.out.println("6.Deletion of book ");
            System.out.println("7.Exit. ");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Is it an EBook? (yes/no): ");
                    String isEBook = scanner.nextLine();
                    Author author = new Author(authorName);

                    if (isEBook.equalsIgnoreCase("yes")) {
                        System.out.print("Enter file format (e.g., PDF, EPUB): ");
                        String format = scanner.nextLine();
                        EBook ebook = new EBook(title, author, format);
                        library.addBook(ebook);
                    } else {
                        Book book = new Book(title, author);
                        library.addBook(book);
                    }
                    System.out.println("Book added successfully.");
                }
                case 2 -> {
                    System.out.println("\n--- Books in Library ---");
                    for (Book book : library.getBooks()) {
                        System.out.println("- " + book.getTitle() + " by " + book.getAuthor().getName());
                    }
                }
                case 3 -> {
                    System.out.print("Enter reader name: ");
                    String readerName = scanner.nextLine();
                    Reader reader = new Reader(readerName);
                    readerMap.put(readerName, reader);
                    club.addMember(reader);
                    System.out.println("Reader added to reading club.");
                }
                case 4 -> {
                    System.out.print("Enter reader name: ");
                    String readerName = scanner.nextLine();
                    Reader reader = readerMap.get(readerName);
                    if (reader == null) {
                        System.out.println("Reader not found. Please add the reader first.");
                        break;
                    }
                    System.out.println("Choose a book by number:");
                    List<Book> books = library.getBooks();
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i).getTitle());
                    }
                    int bookChoice = Integer.parseInt(scanner.nextLine());
                    if (bookChoice < 1 || bookChoice > books.size()) {
                        System.out.println("Invalid book selection.");
                        break;
                    }
                    reader.readBook(books.get(bookChoice - 1));
                }
                case 5 -> {
                    System.out.println("\n--- Reading Club Members ---");
                    for (Reader member : club.getMembers()) {
                        System.out.println("- " + member.getName());
                    }
                }

                case 6 -> {
                    System.out.println("\n--- Delete a Book ---");
                    System.out.print("Enter book title to delete: ");
                    scanner.nextLine(); // consume leftover newline
                    String titleToDelete = scanner.nextLine();

                    boolean deleted = library.deleteBookByTitle(titleToDelete);
                    if (deleted) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                }

                case 7 -> {
                    System.out.println("Exiting. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
