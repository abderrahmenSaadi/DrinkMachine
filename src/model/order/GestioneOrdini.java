package model.order;
import java.util.ArrayList;
import java.util.List;
import model.beverage.Bevanda;
// SINGLETON creo un unica istanza per tutta la durata del programma
public class GestioneOrdini {

    //Istanza unica
    private static GestioneOrdini instance;

    //Lista delle bevande confermate
    private ArrayList<Bevanda> storicoOrdini;

    //Bevanda che l'utente sta personalizzando durante l'esecuzione
    private Bevanda bevandaCorrente;

    // 2. Costruttore privato: nessuno può fare new GestoreOrdini()
    private GestioneOrdini() {
        this.storicoOrdini = new ArrayList<>();
    }

    //Metodo per ottenere l'unica istanza
    public static GestioneOrdini getInstance() {
        if (instance == null) {
            instance = new GestioneOrdini();
        }
        return instance;
    }

    //Metodo per creare una nuova Bevanda Base
    public void creaNuovaBevandaBase(Bevanda bevanda) {
        this.bevandaCorrente = bevanda;
        System.out.println("Nuova Bevanda Base Creata: " + bevanda);
    }

    //Metodo per aggiungere un nuovo ingrediente alla bevanda
    public void aggiungiIngrediente(Bevanda bevandaDecorata) {
        if (bevandaDecorata == null) {
            System.out.println("Errore: devi prima creare la bevanda");
            return;
        }
        this.bevandaCorrente = bevandaDecorata;
        System.out.println("Ingrediente aggiunto.");
    }

    //Metodo per visualizzare la bevabda
    public void visualizzaBevandaCorrente() {
        if (bevandaCorrente == null) {
            System.out.println("Errore: Nessuna bevanda corrente");
            return;
        }
        System.out.println("Bevanda Corrente ");
        System.out.println("Descrizione: " + bevandaCorrente.getDescrizione());
        System.out.println("Prezzo: " + bevandaCorrente.getPrezzo() + " €");

    }

    //Metodo per confermare l'ordine e salvarlo nello storico
    public void confermaOrdine() {
        if (bevandaCorrente == null) {
            System.out.println("Errore: Nessuna bevanda da confermare");
            return;
        }

        //Salvo la bevanda nello storico
        storicoOrdini.add(bevandaCorrente);
        System.out.println("Ordine confermato");
        System.out.println(bevandaCorrente.getDescrizione());
        System.out.println("Totale: " + bevandaCorrente.getPrezzo() + " €");


        //resetto la bevanda;
        bevandaCorrente = null;
    }

    //Metodo per visualizzare tutti gli ordini confermati

    public void visualizzaStorico() {
        if (storicoOrdini.isEmpty()) {
            System.out.println("Errore: non ci sono ordini nello storico crea almeno un ordine");
            return;
        }

        System.out.println("==== STORICO ORDINI =====");
        for (int i = 0; i < storicoOrdini.size(); i++) {

            Bevanda ordine = storicoOrdini.get(i);

            System.out.println("ordine: " + (i + 1));

            System.out.println("Descrizione: " + ordine.getDescrizione());
            System.out.println("Costo: " + ordine.getPrezzo() + " €");
            System.out.println("-------------------------");

        }


    }

    //Metodo per recuperare la bevanda corrente
    public Bevanda getBevandaCorrente() {
        return bevandaCorrente;
    }


}
