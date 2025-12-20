import java.util.ArrayList;

public class Pieces {

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
    public ArrayList<Case> deplacement_possibles(Plateau plateau) {
        return  null;
    };
    public Boolean avancerColLine(int col, int line , Plateau plateau) {
        return  null;
    }
/*  public void avancer(){
        Case pos = this.getPosition();
        System.out.println(pos);
        //if(){}
     //   return setPosition();
    }
*/
}

