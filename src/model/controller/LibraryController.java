package model.controller;

import model.service.LibraryService;
import model.Book;
import model.LibraryItem;
import model.Magazine;
import model.User;
import model.Admin;
import model.Student;

import java.util.Scanner;

public class LibraryController {

    private LibraryService service = new LibraryService();
    private Scanner scanner = new Scanner(System.in);

    // ✅ Logged-in user (IMPORTANT FIX)
    private User currentUser;

    public void run() {

        currentUser = login();

        if (currentUser == null) {
            return;
        }

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book (Admin)");
            System.out.println("2. Add Magazine (Admin)");
            System.out.println("3. Show Items");
            System.out.println("4. Issue Item (Student)");
            System.out.println("5. Return Item (Student)");
            System.out.println("6. Search Item");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = getIntInput("");

            try {
                switch (choice) {

                    case 1:
                        addBook();
                        break;

                    case 2:
                        addMagazine();
                        break;

                    case 3:
                        service.showBooks();
                        break;

                    case 4:
                        issueBook();
                        break;

                    case 5:
                        returnBook();
                        break;

                    case 6:
                        searchBook();
                        break;

                    case 7:
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

    // ✅ LOGIN SYSTEM
    private User login() {

        if (scanner.hasNextLine()) {
                scanner.nextLine();
          }// clear buffer

        System.out.print("Enter role (admin/student): ");
        String role = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (role.equalsIgnoreCase("admin") && password.equals("admin123")) {
            System.out.println("Logged in as Admin");
            return new Admin(1, "Admin");
        } 
        else if (role.equalsIgnoreCase("student") && password.equals("student123")) {
            System.out.println("Logged in as Student");
            return new Student(2, "Student");
        } 
        else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }

    // ✅ ADMIN ONLY
    private void addBook() {
        int id = getIntInput("Enter Book ID: ");

        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        try {
            service.addBook(new Book(id, title), currentUser);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // ✅ ADMIN ONLY
    private void addMagazine() {
        int id = getIntInput("Enter Magazine ID: ");

        scanner.nextLine();

        System.out.print("Enter Magazine Title: ");
        String title = scanner.nextLine();

        int issueNumber = getIntInput("Enter Issue Number: ");

        try {
            service.addBook(new Magazine(id, title, issueNumber), currentUser);
            System.out.println("Magazine added successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // ✅ STUDENT ONLY
    private void issueBook() {
        int id = getIntInput("Enter Item ID: ");

        try {
            service.issueBook(id, currentUser);
            System.out.println("Item issued successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // ✅ STUDENT ONLY
    private void returnBook() {
        int id = getIntInput("Enter Item ID: ");

        try {
            service.returnBook(id, currentUser); // ✅ FIXED (was wrong before)
            System.out.println("Item returned successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void searchBook() {
        int id = getIntInput("Enter Item ID to search: ");

        try {
            LibraryItem item = service.searchBook(id);

            System.out.println("\n--- Item Found ---");
            item.displayDetails(); // ✅ Polymorphism

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}