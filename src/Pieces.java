import java.util.ArrayList;
import java.util.Map;

public abstract class Pieces {

    private String couleur;
    private String nom;
    private String type;
    private Boolean enJeux;
    private Case position;
    private String unicode;

    public Pieces( String nom,String couleur,boolean enJeux,Case position,String type,String unicode) {
        this.nom=nom;
        this.couleur=couleur;
        this.enJeux=enJeux;
        this.position=position;
        this.type="Pieces";
        this.unicode=unicode;

    }
    /*public Pieces() {
    }*/

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
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

    public Boolean getEnJeux() {
        return enJeux;
    }

    public void setEnJeux(Boolean enJeux) {
        this.enJeux = enJeux;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean avancerColLine(int col, int line , Plateau plateau) {
        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();

        Case nextCase = plateau.terrain[col][line];
        if (nextCase.getStatus() && !nextCase.getPiece().getCouleur().equals(couleurPion)) {
            System.out.println(" * Vous mangez " + nextCase.getPiece().getType() +' '+ nextCase.getPiece().getCouleur() + " de votre adversaire! * ");
            nextCase.getPiece().setEnJeux(false);

        }else if (nextCase.getStatus() && nextCase.getPiece().getCouleur().equals(couleurPion)){
            System.out.println("Une de vos piece se trouve déja sur cette case.");
            return false;
        }

        System.out.println("La piece avance");
        // L'ancienne case devient vide
        currentPos.setStatus(false);
        currentPos.setPiece(null);

        // La position du pion change
        this.setPosition(nextCase);

        // La nouvelle case devient occupée
        nextCase.setStatus(true);
        nextCase.setPiece(this);

        //Met fin au tour du joueur
        return true;

    }


    public abstract ArrayList<Case> deplacement_possibles(Plateau plateau);
}

