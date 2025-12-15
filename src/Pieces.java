
public class Pieces {

    private String couleur;
    private String nom;
    private String type;
    private Boolean enJeux;
    private Case position;

    public Pieces( String nom,String couleur,boolean enJeux,Case position,String type) {
        this.nom=nom;
        this.couleur=couleur;
        this.enJeux=enJeux;
        this.position=position;
        this.type=type;

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

  /*  public void avancer(){
        Case pos = this.getPosition();
        System.out.println(pos);
        //if(){}
     //   return setPosition();
    }
*/
}

