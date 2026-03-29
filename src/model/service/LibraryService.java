package model.service;


import model.Admin;
import model.LibraryItem;
import model.Student;
import model.User;
import model.repository.BookRepository;
import model.repository.Repository;
import model.exception.BookNotFoundException;
import model.exception.DuplicateBookException;

public class LibraryService {

   private Repository<LibraryItem> repo = new BookRepository();

    public void addBook(LibraryItem book, User user) throws DuplicateBookException {

    if (!(user instanceof Admin)) {
        throw new RuntimeException("Only Admin can add items!");
    }

    repo.save(book);
}

    public void issueBook(int id, User user) throws BookNotFoundException {

    if (!(user instanceof Student)) {
        throw new RuntimeException("Only Students can issue items!");
    }

    LibraryItem item = repo.findById(id);   

    if (item == null) {
        throw new BookNotFoundException("Item not found");
    }

    if (item.isIssued()) {
        throw new RuntimeException("Item already issued");
    }

    item.issue();   
}
    public void returnBook(int id, User user) throws BookNotFoundException {

    if (!(user instanceof Student)) {
        throw new RuntimeException("Only Students can return items!");
    }

    LibraryItem item = repo.findById(id);

    if (item == null) {
        throw new BookNotFoundException("Item not found");
    }

    item.returnBook();
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