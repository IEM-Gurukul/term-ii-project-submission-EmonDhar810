package model.controller;

import model.service.LibraryService;
import model.Book;
import model.LibraryItem;

import java.util.Scanner;

public class LibraryController {

    private LibraryService service = new LibraryService();
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {

                    case 1:
                        addBook();
                        break;

                    case 2:
                        service.showBooks();
                        break;

                    case 3:
                        issueBook();
                        break;

                    case 4:
                        returnBook();
                        break;

                    case 5:
                        searchBook();
                        break;

                    case 6:
                        System.out.println("Exiting..."); 
                        return;  

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

   private void addBook() {
    int id = getIntInput("Enter Book ID: ");

    scanner.nextLine(); // clear buffer

    System.out.print("Enter Book Title: ");
    String title = scanner.nextLine();

    try {
        service.addBook(new Book(id, title));  
        System.out.println("Book added successfully!");
    } catch (Exception e) {                     
        System.out.println("ERROR: " + e.getMessage());
    }
}

   private void issueBook() {
    int id = getIntInput("Enter Book ID: ");

    try {
        service.issueBook(id);
        System.out.println("Book issued successfully!");
    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
  }
  
  private void returnBook() {
    int id = getIntInput("Enter Book ID: ");

    try {
        service.returnBook(id);
        System.out.println("Book returned successfully!");
    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
} 

private void searchBook() {
    int id = getIntInput("Enter Book ID to search: ");

    try {
        LibraryItem book = service.searchBook(id);

        System.out.println("\n--- Book Found ---");
        System.out.println(
            "ID: " + book.getId() +
            ", Title: " + book.getTitle() +
            ", Status: " + (book.isIssued() ? "Issued" : "Available")
        );

    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
}

    private int getIntInput(String message) {
    while (true) {
        System.out.print(message);
        try {
            int value = scanner.nextInt();
            return value;
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); // clear buffer
        }
    }
}
}
