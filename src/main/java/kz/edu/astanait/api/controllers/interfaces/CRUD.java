package kz.edu.astanait.api.controllers.interfaces;

import java.util.List;

public interface CRUD<T> {
    void add(T entity);
    void update(T entity);
    void delete(Integer id);
    List<T> getAll();
}
