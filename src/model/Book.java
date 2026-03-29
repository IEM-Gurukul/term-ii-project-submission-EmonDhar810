package model;

public class Book extends LibraryItem {

    public Book(int id, String title) {
        super(id, title);
    }

    @Override
    public void displayDetails() {
        System.out.println(
            "ID: " + id +
            ", Title: " + title +
            ", Status: " + (isIssued() ? "Issued" : "Available")
        );
    }
}