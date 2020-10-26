package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.models.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookController {

    public void updateBook(Book book) {
        StringBuilder sb = new StringBuilder("UPDATE BOOKS SET ");

        if (book.getName() != null) sb.append("NAME=?,");
        if (book.getAuthor() != null) sb.append("AUTHOR=?,");
        if (book.getCount_of_copy() != null) sb.append("COUNT_OF_COPY=?,");

        sb.deleteCharAt(sb.length() - 1); // Deletes last coma (,)
        sb.append(" WHERE ISBN=?");

        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement(sb.toString());

            int i = 1;
            if (book.getName() != null) preparedStatement.setString(i++, book.getName());
            if (book.getAuthor() != null) preparedStatement.setString(i++, book.getAuthor());
            if (book.getCount_of_copy() != null) preparedStatement.setInt(i++, book.getCount_of_copy());
            preparedStatement.setString(i, book.getISBN());

            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
