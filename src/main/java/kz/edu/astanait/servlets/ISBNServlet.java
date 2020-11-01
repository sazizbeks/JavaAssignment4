package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.DB;

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

@WebServlet(name = "ISBN", urlPatterns = "/ISBN")
public class ISBNServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =  DB.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;


        String ISBN = request.getParameter("ISBN");

        try{
            pst = conn.prepareStatement("SELECT * FROM books WHERE ISBN = ?");
            pst.setString(1,ISBN);
            rs = pst.executeQuery();

            if(rs.next()){
                response.setContentType("text/html");
                String json = new Gson().toJson("Not available");
                response.getWriter().write(json);
            }
            else{
                response.setContentType("text/html");
                String json = new Gson().toJson("available");
                response.getWriter().write(json);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
