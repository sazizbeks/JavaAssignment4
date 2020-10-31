package kz.edu.astanait.servlets;

import kz.edu.astanait.apiClients.ReaderClient;
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
    ReaderClient rc = new ReaderClient();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String iin = request.getParameter("iin");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String btnVal = request.getParameter("btn");

        Reader reader = new Reader(iin,firstName,lastName);


        switch (btnVal){
            case ("Add"):
                rc.addReader(reader);
                doGet(request,response);
                break;
            case("Edit"):
                rc.updateReader(reader);
                doGet(request,response);
                break;
            case ("delete"):
                rc.deleteReader(reader.getIin());
                response.sendRedirect(request.getHeader("Referer"));
                return;
            case ("search"):
                rc.getReader(iin);
                doGet(request,response);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
