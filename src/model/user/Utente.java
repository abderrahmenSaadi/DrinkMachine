public class Utente{

    private String nomeUtente;
    private String passwdUtente;
    private double creditoUtente;
    private boolean isAdimn;

    public Utente(String nomeUtente, String passwdUtente, double creditoUtente, boolean isAdimn){
        this.nomeUtente = nomeUtente;
        this.passwdUtente = passwdUtente;
        this.creditoUtente = creditoUtente;
        this.isAdimn = isAdimn;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPasswdUtente() {
        return passwdUtente;
    }
    public void setPasswdUtente(String passwdUtente) {
        this.passwdUtente = passwdUtente;
    }

    public double getCreditoUtente() {
        return creditoUtente;
    }

    public boolean isAdimn() {
        return isAdimn;
    }

    public void aggiungiCredito(double creditoAggiunto){
        if(isAdimn){
            System.out.println("Sei un utente Adimn e puoi comprare quello che vuoi " );
            return;
        }
        this.creditoUtente += creditoAggiunto;
        System.out.println("Credito aggiunto: " + creditoAggiunto);
        System.out.println("Totale Credito: " + this.creditoUtente);
    }



}
