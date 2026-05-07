package model.order;

import model.beverage.Bevanda;
import model.user.Utente;

public class Ordine {

    private int id;

    private Bevanda bevanda;

    private Utente utente;

    public Ordine(
            int id,
            Bevanda bevanda,
            Utente utente
    ) {

        this.id = id;

        this.bevanda = bevanda;

        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public Bevanda getBevanda() {
        return bevanda;
    }

    public Utente getUtente() {
        return utente;
    }

    public double getTotale() {

        if (utente.isAdmin()) {

            return 0.0;
        }

        return bevanda.getPrezzo();
    }
}