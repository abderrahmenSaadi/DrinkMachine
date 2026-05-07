package controller;

import dao.OrdineDAO;
import model.beverage.*;
import model.order.GestoreOrdini;
import model.order.Ordine;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class OrdineController {

    private List<Bevanda> bevandeCorrenti;

    private ConsoleView view;

    private OrdineDAO ordineDAO;

    public OrdineController(
            ConsoleView view
    ) {

        this.view = view;

        ordineDAO = new OrdineDAO();

        bevandeCorrenti =
                new ArrayList<>();
    }

    public void creaCaffe() {

        bevandeCorrenti.add(
                new Caffe()
        );

        view.mostraMessaggio(
                "Caffe aggiunto all'ordine."
        );
    }

    public void creaTe() {

        bevandeCorrenti.add(
                new Te()
        );

        view.mostraMessaggio(
                "Te aggiunto all'ordine."
        );
    }

    public void creaCioccolata() {

        bevandeCorrenti.add(
                new CioccolataCalda()
        );

        view.mostraMessaggio(
                "Cioccolata aggiunta all'ordine."
        );
    }

    public void aggiungiLatte(
            int indice
    ) {

        if (!indiceValido(indice)) {
            return;
        }

        Bevanda bevanda =
                bevandeCorrenti.get(indice);

        bevanda =
                new Latte(bevanda);

        bevandeCorrenti.set(
                indice,
                bevanda
        );
    }

    public void aggiungiZucchero(
            int indice
    ) {

        if (!indiceValido(indice)) {
            return;
        }

        Bevanda bevanda =
                bevandeCorrenti.get(indice);

        bevanda =
                new Zucchero(bevanda);

        bevandeCorrenti.set(
                indice,
                bevanda
        );
    }

    public void aggiungiPanna(
            int indice
    ) {

        if (!indiceValido(indice)) {
            return;
        }

        Bevanda bevanda =
                bevandeCorrenti.get(indice);

        bevanda =
                new Panna(bevanda);

        bevandeCorrenti.set(
                indice,
                bevanda
        );
    }

    public void aggiungiCannella(
            int indice
    ) {

        if (!indiceValido(indice)) {
            return;
        }

        Bevanda bevanda =
                bevandeCorrenti.get(indice);

        bevanda =
                new Cannella(bevanda);

        bevandeCorrenti.set(
                indice,
                bevanda
        );
    }

    public void aggiungiCacao(
            int indice
    ) {

        if (!indiceValido(indice)) {
            return;
        }

        Bevanda bevanda =
                bevandeCorrenti.get(indice);

        bevanda =
                new Cacao(bevanda);

        bevandeCorrenti.set(
                indice,
                bevanda
        );
    }

    private boolean indiceValido(
            int indice
    ) {

        if (bevandeCorrenti.isEmpty()) {

            view.mostraMessaggio(
                    "Nessuna bevanda presente."
            );

            return false;
        }

        if (indice < 0 ||
            indice >= bevandeCorrenti.size()) {

            view.mostraMessaggio(
                    "Indice non valido."
            );

            return false;
        }

        return true;
    }

    public void visualizzaBevande() {

        if (bevandeCorrenti.isEmpty()) {

            view.mostraMessaggio(
                    "Nessuna bevanda presente."
            );

            return;
        }

        for (int i = 0;
             i < bevandeCorrenti.size();
             i++) {

            Bevanda bevanda =
                    bevandeCorrenti.get(i);

            System.out.println(
                    "[" + i + "] "
                    + bevanda.getDescrizione()
                    + " - €"
                    + bevanda.getPrezzo()
            );
        }
    }

public void confermaOrdine() {

    if (bevandeCorrenti.isEmpty()) {

        view.mostraMessaggio(
                "Nessuna bevanda presente."
        );

        return;
    }

    int idOrdine =
            GestoreOrdini
                    .getIstanza()
                    .generaIdOrdine();

    Ordine ordine =
            new Ordine(
                    idOrdine,
                    new ArrayList<>(
                            bevandeCorrenti
                    )
            );

    GestoreOrdini
            .getIstanza()
            .aggiungiOrdine(ordine);

    ordineDAO.salvaOrdine(
            ordine
    );

    view.mostraMessaggio(
            "Ordine confermato."
    );

    bevandeCorrenti.clear();
}

    public void mostraStorico() {

        view.mostraStorico(
                GestoreOrdini
                        .getIstanza()
                        .getOrdini()
        );
    }
}