package dao;

import database.ConnessioneDatabase;
import model.order.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineDAO {

    private Connection connessione;

    private BevandaDAO bevandaDAO;

    private IngredienteDAO ingredienteDAO;

    public OrdineDAO() {

        connessione =
                ConnessioneDatabase
                        .getIstanza()
                        .getConnessione();

        bevandaDAO = new BevandaDAO();

        ingredienteDAO = new IngredienteDAO();
    }

    public void salvaOrdine(Ordine ordine) { String sql =
                "INSERT INTO ordini(costo_totale) VALUES (?)";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(
                            sql,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );

            statement.setDouble(
                    1,
                    ordine.getBevanda().getCosto()
            );

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();

            int ordineId = -1;

            if (keys.next()) {
                ordineId = keys.getInt(1);
            }

            int bevandaId =
                    bevandaDAO.salvaBevanda(
                            ordine.getBevanda(),
                            ordineId
                    );

            salvaIngredientiBevanda(
                    bevandaId,
                    ordine.getBevanda()
            ); System.out.println(
                    "Ordine salvato nel database."
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void salvaIngredientiBevanda(
            int bevandaId,
            model.bevanda.Bevanda bevanda
    ) {

        String sql =
                "INSERT INTO bevanda_ingredienti(bevanda_id, ingrediente_id) VALUES (?, ?)";

        for (String nomeIngrediente : bevanda.getIngredienti()) {

            int ingredienteId =
                    ingredienteDAO.getIdIngrediente(
                            nomeIngrediente
                    );

            try {

                PreparedStatement statement =
                        connessione.prepareStatement(sql);

                statement.setInt(1, bevandaId);

                statement.setInt(2, ingredienteId);

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}