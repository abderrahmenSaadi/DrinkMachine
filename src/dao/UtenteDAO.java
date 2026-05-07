package dao;

import database.ConnessioneDatabase;
import model.user.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {

    private Connection connessione;

    public UtenteDAO() {

        connessione =
                ConnessioneDatabase
                        .getIstanza()
                        .getConnessione();
    }

    public Utente login(
            String username,
            String password
    ) {

        String sql =
                "SELECT * FROM utenti WHERE username = ? AND password = ?";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(sql);

            statement.setString(
                    1,
                    username
            );

            statement.setString(
                    2,
                    password
            );

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return new Utente(
                        result.getInt("id"),
                        result.getString("username"),
                        result.getString("password"),
                        result.getString("ruolo")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}