package model.repository;

import model.Book;
import model.LibraryItem;
import model.exception.DuplicateBookException;

import java.util.*;

public class BookRepository {

    private Map<Integer, LibraryItem> storage = new HashMap<>();

    public void save(Book book) throws DuplicateBookException {
        if (storage.containsKey(book.getId())) {
            throw new DuplicateBookException(
                "Book with ID " + book.getId() + " already exists"
            );
        }
        storage.put(book.getId(), book);
    }

    public LibraryItem findById(int id) {
        return storage.get(id);
    }

    public Collection<LibraryItem> findAll() {
        return storage.values();
    }
}