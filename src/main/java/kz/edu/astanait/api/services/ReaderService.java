package kz.edu.astanait.api.services;

import kz.edu.astanait.api.controllers.ReaderController;
import kz.edu.astanait.api.controllers.interfaces.IReaderController;
import kz.edu.astanait.models.Reader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reader")
public class ReaderService {
    private final IReaderController readerController = new ReaderController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Reader> readers;
        try {
            readers = readerController.getAll();
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(readers)
                .build();
    }

    @GET
    @Path("/{iin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIin(@PathParam("iin") String iin) {
        Reader reader;
        try {
            reader = readerController.getByIin(iin);
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(reader)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReader(Reader reader) {
        try {
            readerController.add(reader);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("New reader added successfully.")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReader(Reader reader) {
        try {
            readerController.update(reader);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("Reader updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{iin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteReader(@PathParam("iin") String iin) {
        try{
            readerController.delete(iin);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("Reader hasn't deleted.")
                    .build();
        }
        return Response
                .ok("Reader deleted successfully.")
                .build();
    }

    @DELETE
    @Path("/{iin}_{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteReader(@PathParam("iin") String iin, @PathParam("isbn") String isbn) {
        try{
            readerController.deleteReadersBook(iin,isbn);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("Reader's book hasn't deleted.")
                    .build();
        }
        return Response
                .ok("Reader's book deleted successfully.")
                .build();
    }
}
