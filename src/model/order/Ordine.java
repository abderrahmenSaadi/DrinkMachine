package model.order;

import model.beverage.Bevanda;

import java.util.List;

public class Ordine {

    private int id;

    private List<Bevanda> bevande;

    public Ordine(
            int id,
            List<Bevanda> bevande
    ) {

        this.id = id;

        this.bevande = bevande;
    }

    public int getId() {
        return id;
    }

    public List<Bevanda> getBevande() {
        return bevande;
    }
}