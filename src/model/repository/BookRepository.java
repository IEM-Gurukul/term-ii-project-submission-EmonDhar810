package model.repository;

import model.LibraryItem;
import model.exception.DuplicateBookException;

import java.util.*;

public class BookRepository implements Repository<LibraryItem> {

    private Map<Integer, LibraryItem> storage = new HashMap<>();

    public void save(LibraryItem item) throws DuplicateBookException {
    if (storage.containsKey(item.getId())) {
        throw new DuplicateBookException(
            "Book with ID " + item.getId() + " already exists"
        );
    }
    storage.put(item.getId(), item);
}

    public LibraryItem findById(int id) {
        return storage.get(id);
    }

    public Collection<LibraryItem> findAll() {
        return storage.values();
    }
}