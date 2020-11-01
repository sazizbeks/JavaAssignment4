package kz.edu.astanait.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session != null){
            session.removeAttribute("librarian");
        }

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        response.sendRedirect("start.jsp");
    }
}
