package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IReaderController;
import kz.edu.astanait.models.Reader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReaderController implements IReaderController {
    @Override
    public void add(Reader entity) {

    }

    @Override
    public void update(Reader entity) {
        StringBuilder sb = new StringBuilder("UPDATE READERS SET ");

        if (entity.getFirstName() != null) sb.append("FNAME=?,");
        if (entity.getLastName() != null) sb.append("LNAME=?,");

        sb.deleteCharAt(sb.length() - 1); // Deletes last coma (,)
        sb.append(" WHERE ID=?");

        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement(sb.toString());

            int i = 1;
            if (entity.getFirstName() != null) preparedStatement.setString(i++, entity.getFirstName());
            if (entity.getLastName() != null) preparedStatement.setString(i++, entity.getLastName());
            preparedStatement.setString(i, entity.getIin());

            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Reader> getAll() {
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
            throwable.printStackTrace();
        }
        return readers;
    }
}
