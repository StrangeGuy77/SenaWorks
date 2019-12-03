package helpers;

import java.sql.*;

public class Conexion {

    public static java.sql.Connection conectar() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projectosenauno", "strangeguy", "losdelsur");
        } catch (SQLException e){
            System.out.println("There was an error in the connection to the database: " + e.getMessage());
        }
        return (null);
    }

}