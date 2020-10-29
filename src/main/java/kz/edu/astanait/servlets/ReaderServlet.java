package kz.edu.astanait.servlets;

import kz.edu.astanait.models.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = "/readerServ")
public class ReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String REST_URI = "http://localhost:8080/Assignment4_war/api/reader/";
        WebTarget target = ClientBuilder.newBuilder().build().target(REST_URI);

        String iin = request.getParameter("iin");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");

        Reader reader = new Reader(iin,firstName,lastName);

        if(request.getParameter("btn").equals("Add")){
            WebTarget resource = target.path("add");
            resource.request(MediaType.APPLICATION_JSON).put(Entity.json(reader)).readEntity(Reader.class);
            doGet(request,response);
        }



//        System.out.println(resource.request(MediaType.APPLICATION_JSON).get(Reader.class));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
