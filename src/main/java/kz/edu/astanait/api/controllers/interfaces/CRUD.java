package kz.edu.astanait.api.controllers.interfaces;

import javax.ws.rs.BadRequestException;
import java.util.List;

public interface CRUD<T> {
    void add(T entity) throws BadRequestException;
    void update(T entity) throws BadRequestException;
    void delete(String id) throws BadRequestException;
    List<T> getAll() throws BadRequestException;
}
