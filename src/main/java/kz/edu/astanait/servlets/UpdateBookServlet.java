package kz.edu.astanait.servlets;

import kz.edu.astanait.apiClients.BookClient;
import kz.edu.astanait.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBookServlet", urlPatterns = "/updateBook")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookClient client = new BookClient();
        String isbn = null;
        String name = null;
        String author = null;
        Integer countOfCopy = null;
        String image = null;

        if (!req.getParameter("ISBN").isEmpty())
            isbn = req.getParameter("ISBN");

        if (!req.getParameter("Name").isEmpty())
            name = req.getParameter("Name");

        if (!req.getParameter("Author").isEmpty())
            author = req.getParameter("Author");

        if (!req.getParameter("CountOfCopy").isEmpty())
            countOfCopy = Integer.valueOf(req.getParameter("CountOfCopy"));

        if (!req.getParameter("image").isEmpty())
            image = req.getParameter("image");

        client.updateBook(new Book(isbn, name, author, countOfCopy, image));
        resp.sendRedirect(getServletContext().getContextPath() +  "/start");
    }
}
