package controller;

import dao.OrdineDAO;

import model.beverage.*;

import model.order.GestoreOrdini;
import model.order.Ordine;

import model.user.Utente;

import view.ConsoleView;

public class OrdineController {

    private Bevanda bevandaCorrente;

    private ConsoleView view;

    private OrdineDAO ordineDAO;

    private Utente utente;

    public OrdineController(
            ConsoleView view,
            Utente utente
    ) {

        this.view = view;

        this.utente = utente;

        ordineDAO =
                new OrdineDAO();
    }

    public void creaCaffe() {

        if (bevandaCorrente != null) {

            view.mostraMessaggio(
                    "Conferma prima l'ordine corrente."
            );

            return;
        }

        bevandaCorrente =
                new Caffe();

        view.mostraMessaggio(
                "Caffe creato."
        );
    }

    public void creaTe() {

        if (bevandaCorrente != null) {

            view.mostraMessaggio(
                    "Conferma prima l'ordine corrente."
            );

            return;
        }

        bevandaCorrente =
                new Te();

        view.mostraMessaggio(
                "Te creato."
        );
    }

    public void creaCioccolata() {

        if (bevandaCorrente != null) {

            view.mostraMessaggio(
                    "Conferma prima l'ordine corrente."
            );

            return;
        }

        bevandaCorrente =
                new CioccolataCalda();

        view.mostraMessaggio(
                "Cioccolata creata."
        );
    }

    public void aggiungiLatte() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new Latte(
                        bevandaCorrente
                );
    }

    public void aggiungiZucchero() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new Zucchero(
                        bevandaCorrente
                );
    }

    public void aggiungiPanna() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new Panna(
                        bevandaCorrente
                );
    }

    public void aggiungiCannella() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new Cannella(
                        bevandaCorrente
                );
    }

    public void aggiungiCacao() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new Cacao(
                        bevandaCorrente
                );
    }

    public void aggiungiDecoratoreCustom(
            String nome,
            double prezzo
    ) {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Crea prima una bevanda."
            );

            return;
        }

        bevandaCorrente =
                new DecoratoreCustom(
                        bevandaCorrente,
                        nome,
                        prezzo
                );

        view.mostraMessaggio(
                "Decoratore custom '"
                        + nome
                        + "' aggiunto."
        );
    }

    public void visualizzaBevanda() {

        if (bevandaCorrente == null) {

            view.mostraMessaggio(
                    "Nessuna bevanda presente."
            );

            return;
        }

        view.mostraBevanda(
                bevandaCorrente
        );
    }

    public void confermaOrdine() {

        if (bevandaCorrente == null) {

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
                        bevandaCorrente,
                        utente
                );

        GestoreOrdini
                .getIstanza()
                .aggiungiOrdine(
                        ordine
                );

        ordineDAO.salvaOrdine(
                ordine
        );

        view.mostraMessaggio(
                "Ordine confermato."
        );

        bevandaCorrente = null;
    }

    public void mostraStorico() {

        view.mostraStorico(
                GestoreOrdini
                        .getIstanza()
                        .getOrdini()
        );
    }
}