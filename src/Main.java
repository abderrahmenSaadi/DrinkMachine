import controller.OrdineController;

import dao.DecoratoreCustomDAO;
import dao.UtenteDAO;

import database.ConnessioneDatabase;

import model.order.GestoreOrdini;
import model.order.ReceptionistObserver;

import model.user.Utente;

import view.ConsoleView;
import view.MenuView;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConnessioneDatabase
                .getIstanza();

        GestoreOrdini
                .getIstanza()
                .aggiungiObserver(
                        new ReceptionistObserver()
                );

        Scanner scanner =
                new Scanner(System.in);

        UtenteDAO utenteDAO =
                new UtenteDAO();

        System.out.println(
                "=== LOGIN ==="
        );

        System.out.print(
                "Username: "
        );

        String username =
                scanner.next();

        System.out.print(
                "Password: "
        );

        String password =
                scanner.next();

        Utente utente =
                utenteDAO.login(
                        username,
                        password
                );

        if (utente == null) {

            System.out.println(
                    "Login fallito."
            );

            return;
        }

        System.out.println(
                "\nBenvenuto "
                + utente.getUsername()
        );

        if (utente.isAdmin()) {

            System.out.println(
                    "Accesso ADMIN."
            );

        } else {

            System.out.println(
                    "Accesso USER."
            );
        }

        ConsoleView consoleView =
                new ConsoleView();

        MenuView menuView =
                new MenuView();

        OrdineController controller =
                new OrdineController(
                        consoleView,
                        utente
                );

        DecoratoreCustomDAO dao =
                new DecoratoreCustomDAO();

        int scelta;

        do {

            menuView.mostraMenu();

            List<String[]> decoratori =
                    dao.getDecoratori();

            for (int i = 0; i < decoratori.size(); i++) {

                System.out.println(
                        (20 + i)
                        + " - Aggiungi: "
                        + decoratori.get(i)[0]
                        + " (€"
                        + decoratori.get(i)[1]
                        + ")"
                );
            }

            if (utente.isAdmin()) {

                System.out.println(
                        "12 - Aggiungi nuovo decoratore custom"
                );
            }

            scelta =
                    scanner.nextInt();

            if (scelta >= 20
                    && scelta < 20 + decoratori.size()) {

                String[] dec =
                        decoratori.get(scelta - 20);

                controller.aggiungiDecoratoreCustom(
                        dec[0],
                        Double.parseDouble(dec[1])
                );

            } else {

                switch (scelta) {

                    case 1:

                        controller.creaCaffe();

                        break;

                    case 2:

                        controller.creaTe();

                        break;

                    case 3:

                        controller.creaCioccolata();

                        break;

                    case 4:

                        controller.aggiungiLatte();

                        break;

                    case 5:

                        controller.aggiungiZucchero();

                        break;

                    case 6:

                        controller.aggiungiPanna();

                        break;

                    case 7:

                        controller.aggiungiCannella();

                        break;

                    case 8:

                        controller.aggiungiCacao();

                        break;

                    case 9:

                        controller.visualizzaBevanda();

                        break;

                    case 10:

                        controller.confermaOrdine();

                        break;

                    case 11:

                        controller.mostraStorico();

                        break;

                    case 12:

                        if (utente.isAdmin()) {

                            System.out.print(
                                    "Nome decoratore: "
                            );

                            String nome =
                                    scanner.next();

                            System.out.print(
                                    "Prezzo decoratore: "
                            );

                            double prezzo =
                                    scanner.nextDouble();

                            dao.aggiungiDecoratore(
                                    nome,
                                    prezzo
                            );
                        }

                        break;
                }
            }

        } while (scelta != 0);

        System.out.println(
                "\nProgramma terminato."
        );
    }
}