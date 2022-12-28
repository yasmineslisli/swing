package models;
public class Utilisateur extends Personne{
    private String profession;
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String genre, String username, String mdp, String profession, String email) {
        super(nom, prenom, genre, username, mdp);
        this.isAdmin = false;
        this.profession = profession;
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", username='" + username + '\'' +
                ", mdp='" + mdp + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}