package kz.edu.astanait.api.services;

import kz.edu.astanait.api.controllers.ReaderController;
import kz.edu.astanait.api.controllers.interfaces.IReaderController;
import kz.edu.astanait.models.Reader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reader")
public class ReaderService {
    private final IReaderController readerController = new ReaderController();

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addReader(Reader reader) {
        readerController.add(reader);
        return Response
                .ok("New reader added successfully.")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateReader(Reader reader) {
        readerController.update(reader);
        return Response
                .ok("Reader updated successfully.")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteReader(Reader reader) {
        readerController.delete(reader);
        return Response
                .ok("Reader deleted successfully.")
                .build();
    }


}
