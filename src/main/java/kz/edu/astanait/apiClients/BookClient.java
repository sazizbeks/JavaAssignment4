package kz.edu.astanait.apiClients;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kz.edu.astanait.models.Book;
import kz.edu.astanait.models.Reader;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BookClient {
    private String baseURI = "http://localhost:8080/Assignment4_war/api/book/";

    private WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client.target(baseURI);
    }

    public List<Book> getAllBooks() {
        WebTarget target = getWebTarget();
        String json = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        Gson gson = new Gson();
        Book[] books = gson.fromJson(json, Book[].class);

        return new LinkedList<>(Arrays.asList(books));
    }


    public Book getBook(String isbn) {
        WebTarget target = getWebTarget();
        return target.path(isbn).request().accept(MediaType.APPLICATION_JSON).get(Book.class);
    }

    public void addBook(Book book) {
        getWebTarget().request()
                .post(Entity.entity(book, MediaType.APPLICATION_JSON), Response.class);
    }

    public void deleteBook(String isbn) {
        getWebTarget().path(isbn).request().delete();
    }

    public void updateBook(Book book){
        getWebTarget().request().put(Entity.entity(book, MediaType.APPLICATION_JSON), Response.class);
    }
}
