package view;

import model.beverage.Bevanda;
import model.order.Ordine;

import java.util.List;

public class ConsoleView {

    public void mostraMessaggio(
            String messaggio
    ) {

        System.out.println(
                messaggio
        );
    }

    public void mostraBevanda(
            Bevanda bevanda
    ) {

        System.out.println(
                "\n=== BEVANDA ==="
        );

        System.out.println(
                bevanda.getDescrizione()
        );

        System.out.println(
                "Prezzo: €"
                + bevanda.getPrezzo()
        );
    }

    public void mostraStorico(
            List<Ordine> ordini
    ) {

        System.out.println(
                "\n=== STORICO ==="
        );

        for (Ordine ordine : ordini) {

            System.out.println(
                    "\nOrdine #"
                    + ordine.getId()
            );

            System.out.println(
                    ordine.getBevanda()
                            .getDescrizione()
            );

            System.out.println(
                    "Totale: €"
                    + ordine.getBevanda()
                            .getPrezzo()
            );
        }
    }
}