package kz.edu.astanait.servlets;

import kz.edu.astanait.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "BookServlet", urlPatterns = "/bookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        String isbn = request.getParameter("isbn");
        String btnVal = request.getParameter("btnVal");

        PrintWriter pw = response.getWriter();


            String sql = "delete from books where isbn=?";

            try {
                PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

                stmt.setString(1,isbn);
                stmt.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        pw.println("Book deleted successfully!");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
