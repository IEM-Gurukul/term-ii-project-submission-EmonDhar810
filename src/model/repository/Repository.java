package model.repository;

import java.util.Collection;
import model.exception.DuplicateBookException;

public interface Repository<T> {
    void save(T item) throws DuplicateBookException;  
    T findById(int id);
    Collection<T> findAll();
}