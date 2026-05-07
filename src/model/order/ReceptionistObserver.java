package model.order;

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
                "Ordine #" +
                ordine.getId()
        );

        System.out.println(
                "Cliente: " +
                ordine.getUtente()
                        .getUsername()
        );

        System.out.println(
                ordine.getBevanda()
                        .getDescrizione()
        );

        if (ordine.getUtente().isAdmin()) {

            System.out.println(
                    "ADMIN ORDER -> GRATIS"
            );

        } else {

            System.out.println(
                    "Totale ordine: €" +
                    ordine.getTotale()
            );
        }
    }
}