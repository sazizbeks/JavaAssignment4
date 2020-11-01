package kz.edu.astanait;

import kz.edu.astanait.apiClients.ReaderClient;
import kz.edu.astanait.models.Reader;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        // Don't delete this block of code
//        String REST_URI = "http://localhost:8080/Assignment4_war/api/reader/";
//        WebTarget target = ClientBuilder.newBuilder().build().target(REST_URI);
//        WebTarget resource = target.path("getByIin/010425550130");
//        System.out.println(resource.request(MediaType.APPLICATION_JSON).get(Reader.class));
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        ReaderController rd  = new ReaderController();
//        System.out.println(rd.getAll());
//
        ReaderClient rc = new ReaderClient();
//
//        List<Reader> readerList = rc.getAllReaders();
//
//        System.out.println(readerList);
//
//
//        for (Reader r : readerList) {
//            System.out.println(r);
//        }
//        rc.getAllReaders().forEach(System.out::println);
        System.out.println("getReader(String iin)");
        System.out.println(rc.getReader("010425550130"));

        System.out.println("getAllReaders()");
        List<Reader> readerList = rc.getAllReaders();
        readerList.forEach(System.out::println);

//        rc.addReader(new Reader("123456789101", "qwe","erty"));
//        rc.deleteReader("123456789101");
        rc.updateReader(new Reader("123456789101", "qweahahahaha","esdsdrty"));
    }
}
