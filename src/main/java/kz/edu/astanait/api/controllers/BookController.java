package kz.edu.astanait.api.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.api.controllers.interfaces.IBookController;
import kz.edu.astanait.models.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookController implements IBookController {

    @Override
    public void add(Book entity) {

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
            preparedStatement.setString(i, entity.getISBN());

            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
