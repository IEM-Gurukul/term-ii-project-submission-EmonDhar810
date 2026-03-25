package model.repository;

import model.Book;
import java.util.*;

public class BookRepository {

    private Map<Integer, Book> storage = new HashMap<>();

    public void save(Book book) {
        storage.put(book.getId(), book);
    }

    public Book findById(int id) {
        return storage.get(id);
    }

    public Collection<Book> findAll() {
        return storage.values();
    }
}