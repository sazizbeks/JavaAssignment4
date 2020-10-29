package kz.edu.astanait.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/book")
public class BookService {

    /*
        TODO
         delete getClichedMessage() method
         add other methods like in ReaderService
     */

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }
}
