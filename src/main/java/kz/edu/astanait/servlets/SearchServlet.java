package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.DB;
import kz.edu.astanait.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =  DB.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;


        String book = request.getParameter("search");

        try{
            pst = conn.prepareStatement("SELECT * FROM books WHERE name like ?");
            pst.setString(1,"%" + book + "%");
            rs = pst.executeQuery();

            Stack<Book> stack = new Stack<>();
            while(rs.next()){
                    stack.push(new Book(rs.getString("ISBN"),
                            rs.getString("NAME"),
                            rs.getString("AUTHOR"),
                            rs.getInt("COUNT_OF_COPY"),
                            rs.getString("IMG_URL")
                    ));
            }

            response.setContentType("text/html");
            String booksJson =
                        new Gson().toJson(stack);
            response.getWriter().write(booksJson);
            return;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
