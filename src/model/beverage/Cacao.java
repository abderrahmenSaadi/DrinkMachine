package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Cacao extends Decorator {

    public Cacao(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + cacao";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.10;
    }

    @Override
    public List<String> getIngredienti() {

        List<String> ingredienti =
                new ArrayList<>(
                        bevanda.getIngredienti()
                );

        ingredienti.add("Cacao");

        return ingredienti;
    }
}