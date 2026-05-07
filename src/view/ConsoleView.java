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

        if (bevanda == null) {

            System.out.println(
                    "Nessuna bevanda selezionata."
            );

            return;
        }

        System.out.println(
                "\nBevanda corrente:"
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
                "\n=== STORICO ORDINI ==="
        );

        for (Ordine ordine : ordini) {

            System.out.println(
                    "\nOrdine #"
                    + ordine.getId()
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
}