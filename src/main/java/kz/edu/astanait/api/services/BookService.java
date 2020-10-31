package kz.edu.astanait.api.services;

import kz.edu.astanait.api.controllers.BookController;
import kz.edu.astanait.api.controllers.interfaces.IBookController;
import kz.edu.astanait.models.Book;
import kz.edu.astanait.models.Reader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/book")
public class BookService {
    private final IBookController bookController = new BookController();
    /*
        TODO
         delete getClichedMessage() method
         add other methods like in ReaderService
     */


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Book> books;
        try{
            books = bookController.getAll();
        }catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(books)
                .build();
    }

    @GET
    @Path("{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIin(@PathParam("isbn") String isbn) {
        Book book;
        try {
            book = bookController.getByISBN(isbn);
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(book)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        try {
            bookController.add(book);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("New book added successfully.")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book) {
        try {
            bookController.update(book);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("Book updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteReader(@PathParam("isbn") String isbn) {
        try{
            bookController.delete(isbn);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("Book hasn't deleted.")
                    .build();
        }
        return Response
                .ok("Book deleted successfully.")
                .build();
    }
}
