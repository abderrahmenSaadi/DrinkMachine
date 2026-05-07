package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class CioccolataCalda implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Cioccolata calda ";
    }

    @Override
    public double getPrezzo() {
        return 2.0;
    }

    @Override
    public List<String> getIngredienti() {

        return new ArrayList<>();
    }
}
