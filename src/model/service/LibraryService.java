package model.service;

import model.Book;
import model.repository.BookRepository;
import model.exception.BookNotFoundException;

public class LibraryService {

    private BookRepository repo = new BookRepository();

    public void addBook(Book book) {
        repo.save(book);
    }

    public void issueBook(int id) throws BookNotFoundException {
        Book book = repo.findById(id);

        if (book == null) {
            throw new BookNotFoundException("Book not found");
        }

        if (book.isIssued()) {
            throw new RuntimeException("Book already issued");
        }

        book.issue();
    }

    public void returnBook(int id) throws BookNotFoundException {
        Book book = repo.findById(id);

        if (book == null) {
            throw new BookNotFoundException("Book not found");
        }

        book.returnBook();
    }

    public void showBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : repo.findAll()) {
            System.out.println(
                "ID: " + b.getId() +
                ", Title: " + b.getTitle() +
                ", Status: " + (b.isIssued() ? "Issued" : "Available")
            );
        }
    }
}