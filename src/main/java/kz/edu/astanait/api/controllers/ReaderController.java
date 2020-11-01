package kz.edu.astanait.api.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.api.controllers.interfaces.IReaderController;
import kz.edu.astanait.models.Reader;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReaderController implements IReaderController {
    @Override
    public void add(Reader entity) throws BadRequestException {
        String sql = "INSERT INTO READERS(IIN, FNAME, LNAME) VALUES (?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, entity.getIin());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.execute();
        } catch (SQLException throwable) {
            throw new BadRequestException("Reader with such IIN exists.");
        }
    }

    @Override
    public void update(Reader entity) throws BadRequestException {
        StringBuilder sb = new StringBuilder("UPDATE READERS SET ");

        if (entity.getFirstName() != null) sb.append("FNAME=?,");
        if (entity.getLastName() != null) sb.append("LNAME=?,");

        sb.deleteCharAt(sb.length() - 1); // Deletes last coma (,)
        sb.append(" WHERE IIN=?");

        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement(sb.toString());

            int i = 1;
            if (entity.getFirstName() != null) preparedStatement.setString(i++, entity.getFirstName());
            if (entity.getLastName() != null) preparedStatement.setString(i++, entity.getLastName());
            preparedStatement.setString(i, entity.getIin());

            preparedStatement.execute();
        } catch (SQLException throwable) {
            throw new BadRequestException();
        }
    }

    @Override
    public void delete(String id) throws BadRequestException {
        String sql = "DELETE FROM readers WHERE IIN=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException throwable) {
            throw new BadRequestException("Incorrect IIN.");
        }
    }

    @Override
    public List<Reader> getAll() throws BadRequestException {
        List<Reader> readers = new ArrayList<>();
        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM READERS");
            while (rs.next()){
                readers.add(new Reader(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException throwable) {
            throw new BadRequestException();
        }
        return readers;
    }

    @Override
    public Reader getByIin(String iin) throws BadRequestException {
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement("SELECT * FROM READERS WHERE IIN=?");
            ps.setString(1, iin);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Reader(
                        rs.getString("IIN"),
                        rs.getString("FNAME"),
                        rs.getString("LNAME")
                );
            }
        } catch (SQLException throwable) {
            throw new BadRequestException();
        }
        return null;
    }

    @Override
    public void deleteReadersBook(String iin, String isbn) {
        String sql = "DELETE FROM readers_books WHERE IIN=? and ISBN=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, iin);
            ps.setString(2,isbn);

            ps.execute();
        } catch (SQLException throwable) {
            throw new BadRequestException(throwable);
        }
    }
}
