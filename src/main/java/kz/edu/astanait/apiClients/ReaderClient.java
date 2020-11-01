package kz.edu.astanait.apiClients;

import com.google.gson.Gson;
import kz.edu.astanait.models.Reader;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReaderClient {
    private String baseURI = "http://localhost:8080/Assignment4_war/api/reader/";

    private WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client.target(baseURI);
    }

    public List<Reader> getAllReaders() {
        WebTarget target = getWebTarget();
        String json = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        Gson gson = new Gson();
        Reader[] readers = gson.fromJson(json, Reader[].class);

        return new LinkedList<>(Arrays.asList(readers));
    }


    public Reader getReader(String iin) {
        WebTarget target = getWebTarget();
        return target.path(iin).request().accept(MediaType.APPLICATION_JSON).get(Reader.class);
    }

    public void addReader(Reader reader) {
        getWebTarget().request()
                .post(Entity.entity(reader, MediaType.APPLICATION_JSON), Response.class);
    }

    public void deleteReader(String iin) {
        getWebTarget().path(iin).request().delete();
    }

    public void updateReader(Reader reader){
        getWebTarget().request().put(Entity.entity(reader, MediaType.APPLICATION_JSON), Response.class);
    }

    public void deleteReadersBook(String iin,String isbn) {
        getWebTarget().path(iin+"_"+isbn).request().delete();
    }
}
