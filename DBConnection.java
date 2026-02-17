package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/promanage",
                "postgres",
                "Jyoti"
        );
    }
}
