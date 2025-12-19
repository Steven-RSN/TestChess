
public class Plateau {
    private int colonneMax = 4;
    private int ligneMax = 4;
    //terrain en public ???
    public Case[][] terrain;


    public Plateau() {
        this.terrain = new Case[colonneMax][ligneMax];
    }

    public Plateau(int colonneMax, int ligneMax) {
        this.ligneMax = ligneMax;
        this.colonneMax = colonneMax;
        this.terrain = new Case[colonneMax][ligneMax];
    }

    public int getColonneMax() {
        return colonneMax;
    }

    public Case getCase(int col , int ligne){
        return this.terrain[col][ligne];
    }

    public void setColonneMax(int colonneMax) {
        this.colonneMax = colonneMax;
    }

    public int getLigneMax() {
        return ligneMax;
    }

    public void setLigneMax(int ligneMax) {
        this.ligneMax = ligneMax;
    }

    public void getPlateauInfo() {
        for (int i = 0; i <= this.colonneMax; i++) {

            for (int j = 0; j <= this.ligneMax; j++) {

            }
        }
    }

    public void printPlateauTexte(){

        for(int i =0 ; i<this.getLigneMax();i++) {
            System.out.println("   ");

            for(int j =0 ; j<this.getColonneMax();j++) {

                this.terrain[j][i].getCaseInfo();
            }
            System.out.println("   ");

        };
    }

    public void printPlateauSchema(){

        System.out.println("  _  _  _  _  B  _  _  _  _ ");

        for(int i =0 ; i<this.getLigneMax();i++) {
            System.out.println("   ");

            for(int j =0 ; j<this.getColonneMax();j++) {

                this.terrain[j][i].getCaseMemo();
            }
        };
        System.out.println("  ");
        System.out.println("    ");
        System.out.println("  _  _  _  _  N  _  _  _  _ ");


    }
}
