package model.order;

public class ReceptionistObserver implements OrdineObserver {

    @Override
    public void aggiorna(Ordine ordine) {

        System.out.println(
                "\n[RECEPTION] Nuovo ordine ricevuto"
        );

        System.out.println(
                "Ordine #" + ordine.getId()
        );

        System.out.println(
                ordine.getBevanda().getDescrizione()
        );

        System.out.println(
                "Prezzo: €" +
                ordine.getBevanda().getPrezzo()
        );
    }
}