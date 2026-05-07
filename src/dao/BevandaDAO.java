package dao;

import database.ConnessioneDatabase;
import model.beverage.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BevandaDAO {

    private Connection connessione;

    public BevandaDAO() {

        connessione =
                ConnessioneDatabase
                        .getIstanza()
                        .getConnessione();
    }

    public int salvaBevanda(Bevanda bevanda, int ordineId) {
  String sql =
                "INSERT INTO bevande(nome, costo_base, ordine_id) VALUES (?, ?, ?)";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(
                            sql,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );

            statement.setString(
                    1,
                    bevanda.getDescrizione()
            );

            statement.setDouble(
                    2,
                    bevanda.getCosto()
            );

            statement.setInt(3, ordineId);

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                return keys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}