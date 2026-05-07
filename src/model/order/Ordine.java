package model.order;

import model.beverage.Bevanda;

public class Ordine {

    private int id;

    private Bevanda bevanda;

    public Ordine(
            int id,
            Bevanda bevanda
    ) {

        this.id = id;

        this.bevanda = bevanda;
    }

    public int getId() {
        return id;
    }

    public Bevanda getBevanda() {
        return bevanda;
    }
}