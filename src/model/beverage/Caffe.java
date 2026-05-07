package model.beverage;

import java.util.ArrayList;
import java.util.List;

public class Caffe implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Caffè ";
    }

    @Override
    public double getPrezzo() {
        return 1.0;
    }

    @Override
    public List<String> getIngredienti() {

        return new ArrayList<>();
    }
}