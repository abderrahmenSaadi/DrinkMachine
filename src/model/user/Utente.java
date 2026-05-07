package model.user;

public class Utente {

    private int id;

    private String username;

    private String password;

    private String ruolo;

    public Utente(
            int id,
            String username,
            String password,
            String ruolo
    ) {

        this.id = id;

        this.username = username;

        this.password = password;

        this.ruolo = ruolo;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public boolean isAdmin() {

        return ruolo.equalsIgnoreCase(
                "ADMIN"
        );
    }
}