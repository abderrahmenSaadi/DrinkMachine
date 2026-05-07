package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Latte extends Decorator {

    public Latte(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + latte";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.50;
    }

    @Override
    public List<String> getIngredienti() {

        List<String> ingredienti =
                new ArrayList<>(
                        bevanda.getIngredienti()
                );

        ingredienti.add("Latte");

        return ingredienti;
    }
}