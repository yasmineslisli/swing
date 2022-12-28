package models;
public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String genre;
    protected String username;
    protected String mdp;
    protected boolean isAdmin;

    public Personne() {
    }

    public Personne(String nom, String prenom, String genre, String username, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.username = username;
        this.mdp = mdp;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", username='" + username + '\'' +
                ", mdp='" + mdp + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}