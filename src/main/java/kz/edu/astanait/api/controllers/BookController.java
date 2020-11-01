package kz.edu.astanait.api.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.api.controllers.interfaces.IBookController;
import kz.edu.astanait.models.Book;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookController implements IBookController {

    @Override
    public void add(Book entity) {
        String sql = "INSERT INTO books(isbn,name,author,count_of_copy,img_url) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1,entity.getISBN());
            stmt.setString(2,entity.getName());
            stmt.setString(3,entity.getAuthor());
            stmt.setInt(4,entity.getCount_of_copy());
            stmt.setString(5,entity.getAuthor());

            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(Book entity) {
        StringBuilder sb = new StringBuilder("UPDATE BOOKS SET ");

        if (entity.getName() != null) sb.append("NAME=?,");
        if (entity.getAuthor() != null) sb.append("AUTHOR=?,");
        if (entity.getCount_of_copy() != null) sb.append("COUNT_OF_COPY=?,");

        sb.deleteCharAt(sb.length() - 1); // Deletes last coma (,)
        sb.append(" WHERE ISBN=?");

        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement(sb.toString());

            int i = 1;
            if (entity.getName() != null) preparedStatement.setString(i++, entity.getName());
            if (entity.getAuthor() != null) preparedStatement.setString(i++, entity.getAuthor());
            if (entity.getCount_of_copy() != null) preparedStatement.setInt(i++, entity.getCount_of_copy());
            if(entity.getUrl() != null) preparedStatement.setString(i++, entity.getUrl());
            preparedStatement.setString(i, entity.getISBN());

            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void delete(String isbn) {
        String sql = "DELETE FROM books WHERE isbn=?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1,isbn);
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                books.add(new Book(
                        rs.getString("isbn"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("count_of_copy"),
                        rs.getString("img_url")
                ));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getByISBN(String isbn) throws BadRequestException {
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement("SELECT * FROM books WHERE isbn=?");
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Book(
                        rs.getString("isbn"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("count_of_copy"),
                        rs.getString("img_url")
                );
            }
        } catch (SQLException throwable) {
            throw new BadRequestException();
        }
        return null;
    }
}
