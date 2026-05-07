package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class DecoratoreCustom extends Decorator {

    private final String nome;
    private final double prezzo;

    public DecoratoreCustom(
            Bevanda bevanda,
            String nome,
            double prezzo
    ) {

        super(bevanda);
        this.nome = nome;
        this.prezzo = prezzo;
    }

    @Override
    public String getDescrizione() {

        return bevanda.getDescrizione()
                + " + "
                + nome;
    }

    @Override
    public double getPrezzo() {

        return bevanda.getPrezzo()
                + prezzo;
    }

    @Override
    public List<String> getIngredienti() {

        List<String> ingredienti =
                new ArrayList<>(
                        bevanda.getIngredienti()
                );

        ingredienti.add(nome);

        return ingredienti;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoDecoratore() {
        return prezzo;
    }
}
