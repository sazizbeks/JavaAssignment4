package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.DB;
import kz.edu.astanait.api.controllers.BookController;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =  DB.getConnection();
        PreparedStatement stmt = null;


        String isbn = request.getParameter("isbn");

        try{
            stmt = conn.prepareStatement("DELETE FROM books WHERE isbn=?");
            stmt.setString(1,isbn);
            stmt.execute();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
