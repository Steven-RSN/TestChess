public class Joueur {
    private String nom;
    private String couleur;
    private int score=0;
    private boolean joue = false;

    public Joueur(String nom,String couleur){
        this.nom=nom;
        this.couleur=couleur;
    }


    public boolean isJoue() {
        return joue;
    }

    public void setJoue(boolean joue) {
        this.joue = joue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
