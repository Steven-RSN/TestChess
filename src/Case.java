public class Case extends Plateau {
    private int posColonne;
    private int posLigne;
    private String couleur;
    private Boolean status = false;
    private Pieces piece;

    public Case() {
    }

    public Case(String couleur, int posColonne, int posLigne) {
        this.couleur = couleur;
        this.posLigne = posLigne;
        this.posColonne = posColonne;
        //  this.status=status;
    }


    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getPosColonne() {
        return posColonne;
    }

    public void setPosColonne(int posColonne) {
        this.posColonne = posColonne;
    }

    public int getPosLigne() {
        return posLigne;
    }

    public void setPosLigne(int posLigne) {
        this.posLigne = posLigne;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }

    public void getCaseInfo() {
        System.out.print(

                "| Position: " + this.posColonne + '-' + this.posLigne +
                        "  Couleur: " + this.couleur +
                        "  Status: " + isOccuper() + " |"
        );
    }

    public void getCaseMemo() {
        System.out.print(
                "  [" + (this.status ? this.getPiece().getNom() : "   ") + ']'
        );
    }

    public String isOccuper() {
        if (this.status) {
            return "Occupé";
        } else {
            return "Non occupé";
        }
    }

}
