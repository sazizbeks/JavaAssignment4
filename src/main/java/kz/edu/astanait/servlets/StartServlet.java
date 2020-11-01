package kz.edu.astanait.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StartServlet", urlPatterns = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("librarian") == null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/jsp/authorization.jsp");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
        }
    }
}
