package model.beverage;
import java.util.ArrayList;
import java.util.List;
public class Panna extends Decorator {

    public Panna(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + panna";
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

        ingredienti.add("Panna");

        return ingredienti;
    }
}

