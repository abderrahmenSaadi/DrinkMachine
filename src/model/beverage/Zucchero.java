package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Zucchero extends Decorator {

    public Zucchero(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + zucchero";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.05;
    }

    @Override
    public List<String> getIngredienti() {

        List<String> ingredienti =
                new ArrayList<>(
                        bevanda.getIngredienti()
                );

        ingredienti.add("Zucchero");

        return ingredienti;
    }
}