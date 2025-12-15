import java.util.Scanner;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;
    //private Regles regles;

    public Partie(Joueur joueur1, Joueur joueur2, Plateau plateau) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.plateau = plateau;
    }


    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void placerPieces() {
        for (int i = 0; i < plateau.getColonneMax(); i++) {
            Case casePionN = plateau.terrain[i][plateau.getLigneMax() - 1];
            Pion pionN = new Pion("Np" + (i + 1), "Noir", casePionN);
            casePionN.setPiece(pionN);
            casePionN.setStatus(true);

            Case casePionB = plateau.terrain[i][0];
            Pion pionB = new Pion("Bp" + (i + 1), "Blanc", casePionB);
            casePionB.setPiece(pionB);
            casePionB.setStatus(true);
        }
    }

    public void initPartie() {

        for (int i = 0; i < plateau.getColonneMax(); i++) {
            for (int j = 0; j < plateau.getLigneMax(); j++) {

                String couleur;
                if ((i + j) % 2 == 0) {
                    couleur = "Blanc";

                } else {
                    couleur = "Noir";
                }

                Case currentCase = new Case(couleur, i, j);
                plateau.terrain[i][j] = currentCase;
            }
        }
    }

    public void lancerPartie() {
        Scanner scanner= new Scanner(System.in);
        System.out.println(" - - -  La partie est lancé - - -");

        //boucle while gagnant =>true/false
        while (true){

            //boucle while tour j1 =>true/false
            while (joueur1.isJoue()){
                System.out.println("Cest à votre tour de jouer");
                System.out.println("Quel piece voulez vous déplacer ? ");
                scanner.next();

            }
            //boucle while tour j2 =>true/false
            while (joueur2.isJoue()){

            }
        }
    }
}
