package model.order;

import model.beverage.Bevanda;

public class ReceptionistObserver
        implements OrdineObserver {

    @Override
    public void aggiorna(
            Ordine ordine
    ) {

        System.out.println(
                "\n[RECEPTION] Nuovo ordine ricevuto"
        );

        System.out.println(
                "Ordine #" + ordine.getId()
        );

        double totale = 0;

        for (Bevanda bevanda :
                ordine.getBevande()) {

            System.out.println(
                    "- "
                    + bevanda.getDescrizione()
                    + " -> €"
                    + bevanda.getPrezzo()
            );

            totale +=
                    bevanda.getPrezzo();
        }

        System.out.println(
                "Totale ordine: €"
                + totale
        );
    }
}