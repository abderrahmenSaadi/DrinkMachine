package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {

    private static ConnessioneDatabase istanza;

    private Connection connessione;

    private final String URL =
            "jdbc:mysql://localhost:3306/bar";

    private final String USER = "root";

    private final String PASSWORD = "root";

    private ConnessioneDatabase() {

        try {

            connessione = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println(
                    "Connessione al database riuscita."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Errore connessione database."
            );

            e.printStackTrace();
        }
    }

    public static ConnessioneDatabase getIstanza() {

        if (istanza == null) {
            istanza = new ConnessioneDatabase();
        }

        return istanza;
    }

    public Connection getConnessione() {
        return connessione;
    }
}