package kz.edu.astanait.api.controllers.interfaces;

import kz.edu.astanait.models.Book;

import javax.ws.rs.BadRequestException;

public interface IBookController extends CRUD<Book>{
    Book getByISBN(String isbn) throws BadRequestException;
}
