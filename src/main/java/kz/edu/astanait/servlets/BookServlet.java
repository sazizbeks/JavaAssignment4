package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.DB;
import kz.edu.astanait.api.controllers.BookController;
import kz.edu.astanait.apiClients.BookClient;
import kz.edu.astanait.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "BookServlet", urlPatterns = "/bookServlet")
public class BookServlet extends HttpServlet {
    BookClient bc = new BookClient();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int count = Integer.parseInt(request.getParameter("coc"));
        String image = request.getParameter("image");
        String btnVal = request.getParameter("btn");

        Book book = new Book(isbn, name, author, count, image);

        switch (btnVal) {
            case ("Add"):
                bc.addBook(book);
                doGet(request, response);
                break;
            case ("update"):
                bc.updateBook(book);
                doGet(request, response);
                break;
            case ("delete"):
                bc.deleteBook(book.getISBN());
                break;
            case("search"):
                bc.getBook(isbn);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

}
