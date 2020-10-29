package kz.edu.astanait.api.services;

import kz.edu.astanait.api.controllers.ReaderController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reader")
public class ReaderService {
    private final ReaderController readerController = new ReaderController();

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response
                .ok(readerController.getAll())
                .build();
    }

    @GET
    @Path("/getByIin/{iin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIin(@PathParam("iin") String iin) {
        return Response
                .ok(readerController.getByIin(iin))
                .build();
    }

    @POST
    @Path("/delete/{iin}")

}
