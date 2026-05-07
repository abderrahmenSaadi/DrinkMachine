package dao;

import database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DecoratoreCustomDAO {

    private Connection connessione;

    public DecoratoreCustomDAO() {

        connessione =
                ConnessioneDatabase
                        .getIstanza()
                        .getConnessione();
    }

    public void aggiungiDecoratore(
            String nome,
            double prezzo
    ) {

        String sql =
                "INSERT INTO ingredienti(nome, prezzo) VALUES (?, ?)";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(sql);

            statement.setString(
                    1,
                    nome
            );

            statement.setDouble(
                    2,
                    prezzo
            );

            statement.executeUpdate();

            System.out.println(
                    "Decoratore aggiunto con successo."
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<String[]> getDecoratori() {

        List<String[]> lista =
                new ArrayList<>();

        String sql =
                "SELECT nome, prezzo FROM ingredienti "
                + "WHERE nome NOT IN "
                + "('Latte', 'Zucchero', 'Panna', 'Cannella', 'Cacao')";

        try {

            PreparedStatement statement =
                    connessione.prepareStatement(sql);

            ResultSet rs =
                    statement.executeQuery();

            while (rs.next()) {

                lista.add(
                        new String[]{
                                rs.getString("nome"),
                                String.valueOf(
                                        rs.getDouble("prezzo")
                                )
                        }
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return lista;
    }
}