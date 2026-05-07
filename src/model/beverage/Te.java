// src/model/bevanda/Te.java
package model.beverage;

public class Te implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Tè";
    }

    @Override
    public double getPrezzo() {
        return 1.50;
    }
}