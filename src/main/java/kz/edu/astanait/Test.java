package kz.edu.astanait;

import kz.edu.astanait.models.Reader;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Test {
    public static void main(String[] args) {

        // Don't delete this block of code
        String REST_URI = "http://localhost:8080/Assignment4_war/api/reader/";
        WebTarget target = ClientBuilder.newBuilder().build().target(REST_URI);
        WebTarget resource = target.path("getByIin/010425550130");
        System.out.println(resource.request(MediaType.APPLICATION_JSON).get(Reader.class));
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        ReaderController rd  = new ReaderController();
//        System.out.println("Reader is "+rd.getByIin("010425550130"));
    }
}
