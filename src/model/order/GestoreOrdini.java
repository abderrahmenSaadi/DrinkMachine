package model.order;
import java.util.ArrayList;
import java.util.List;

public class GestoreOrdini {

    private static GestoreOrdini istanza;

    private List<Ordine> ordini;

    private List<OrdineObserver> observers;

    private int contatoreOrdini;

    private GestoreOrdini() {

        ordini = new ArrayList<>();

        observers = new ArrayList<>();

        contatoreOrdini = 1;
    }

    public static GestoreOrdini getIstanza() {

        if (istanza == null) {
            istanza = new GestoreOrdini();
        }

        return istanza;
    }

    public int generaIdOrdine() {

        return contatoreOrdini++;
    }

    public void aggiungiOrdine(Ordine ordine) {

        ordini.add(ordine);

        notificaObservers(ordine);
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void aggiungiObserver(OrdineObserver observer) {

        observers.add(observer);
    }

    private void notificaObservers(Ordine ordine) {

        for (OrdineObserver observer : observers) {

            observer.aggiorna(ordine);
        }
    }
}