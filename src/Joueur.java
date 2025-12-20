import java.util.ArrayList;
import java.util.Scanner;

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

    public Pieces selectionPiece(Scanner scanner,Plateau plateau){

        System.out.println("Colonne de la piece deplacer ?");
        int colonne_piece_a_deplacer = scanner.nextInt();
        System.out.println("Ligne de la piece deplacer ?");
        int ligne_piece_a_deplacer = scanner.nextInt();

        //pion_a_deplacer.deplacement_possibles(plateau);
        //parcourir la tab de deplacement possible !!
        return plateau.terrain[colonne_piece_a_deplacer][ligne_piece_a_deplacer].getPiece();
    }

}
