// src/model/bevanda/Te.java
package model.bevanda;

public class Te implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Tè";
    }

    @Override
    public double getCosto() {
        return 1.50;
    }
}