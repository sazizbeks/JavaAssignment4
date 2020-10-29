package kz.edu.astanait.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/book")
public class BookService {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }
}
