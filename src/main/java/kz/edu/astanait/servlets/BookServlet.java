package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        ResultSet rs = null;

        String isbn = request.getParameter("isbn");

        try{
            stmt = conn.prepareStatement("DELETE FROM books WHERE isbn=?");
            stmt.setString(1,isbn);
            boolean bool = stmt.execute();

            if(bool){
                response.setContentType("text/html");
                String json = new Gson().toJson("deleted");
                response.getWriter().write(json);
            }else{
                response.setContentType("text/html");
                String json = new Gson().toJson("error");
                response.getWriter().write(json);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
