package dao;

import database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredienteDAO {

    private Connection connessione;

    public IngredienteDAO() {

        connessione =
                ConnessioneDatabase
                        .getIstanza()
                        .getConnessione();
    }

    public int getIdIngrediente(String nome) {

        String sql =
                "SELECT id FROM ingredienti WHERE nome = ?";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(sql);

            statement.setString(1, nome);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}