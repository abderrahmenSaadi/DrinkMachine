package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Cannella extends Decorator {

    public Cannella(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + cannella";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.20;
    }

    @Override
    public List<String> getIngredienti() {

        List<String> ingredienti =
                new ArrayList<>(
                        bevanda.getIngredienti()
                );

        ingredienti.add("Cannella");

        return ingredienti;
    }
}