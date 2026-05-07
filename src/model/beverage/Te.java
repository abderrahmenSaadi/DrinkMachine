// src/model/bevanda/Te.java
package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Te implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Tè";
    }

    @Override
    public double getPrezzo() {
        return 1.50;
    }

    @Override
    public List<String> getIngredienti() {

        return new ArrayList<>();
    }
}