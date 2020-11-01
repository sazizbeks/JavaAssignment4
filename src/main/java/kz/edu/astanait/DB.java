package kz.edu.astanait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection connection;

    private DB() {
    }

    public static Connection getConnection() {
        if(connection==null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_week_8?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        "ibragim","1234");
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return connection;
    }
}
