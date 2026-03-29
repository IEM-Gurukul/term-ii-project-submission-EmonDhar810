package model.service;


import model.LibraryItem;
import model.repository.BookRepository;
import model.repository.Repository;
import model.exception.BookNotFoundException;
import model.exception.DuplicateBookException;

public class LibraryService {

   private Repository<LibraryItem> repo = new BookRepository();

    public void addBook(LibraryItem book) throws DuplicateBookException {
        repo.save(book);
    }

    public void issueBook(int id) throws BookNotFoundException {
        LibraryItem item = repo.findById(id);   

        if (item == null) {
            throw new BookNotFoundException("Book not found");
        }

        if (item.isIssued()) {
            throw new RuntimeException("Book already issued");
        }

        item.issue();   
    }

    public void returnBook(int id) throws BookNotFoundException {
        LibraryItem item = repo.findById(id);   

        if (item == null) {
            throw new BookNotFoundException("Book not found");
        }

        item.returnItem();   
    }

    public void showBooks() {
        System.out.println("\n--- Library Books ---");
        for (LibraryItem b : repo.findAll()) {
            b.displayDetails();   
        }
    }

    public LibraryItem searchBook(int id) throws BookNotFoundException {
    LibraryItem book = repo.findById(id);

    if (book == null) {
        throw new BookNotFoundException("Book not found");
    }

    return book;
}

}