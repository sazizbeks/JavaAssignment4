package kz.edu.astanait.servlets;

import kz.edu.astanait.models.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorize")
public class AuthorizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!username.equals("AdminLibrarian") || !password.equals("Admin123")){
            Cookie errorCookie = new Cookie("errorAuthorize", "Incorrect_username_or_password!");
            errorCookie.setMaxAge(5);
            response.addCookie(errorCookie);
            response.sendRedirect(request.getHeader("Referer"));
            return;
        }

        Librarian librarian = new Librarian(username,password);
        HttpSession session = request.getSession();
        session.setAttribute("librarian", librarian);
        session.setMaxInactiveInterval(60*60*5);
        response.sendRedirect(getServletContext().getContextPath()+"/start");
    }
}
