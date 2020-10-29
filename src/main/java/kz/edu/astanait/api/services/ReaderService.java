package kz.edu.astanait.api.services;

import kz.edu.astanait.controllers.ReaderController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reader")
public class ReaderService {
    private final ReaderController readerController = new ReaderController();

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(readerController.getAll()).build();
    }
}
