import java.util.ArrayList;
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
            Pion pionN = new Pion("Np" + (i + 1), "Noir", casePionN, "♙");
            casePionN.setPiece(pionN);
            casePionN.setStatus(true);

            Case casePionB = plateau.terrain[i][0];
            Pion pionB = new Pion("Bp" + (i + 1), "Blanc", casePionB, "♟");
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

    public void logo() {

        System.out.print(
                "\n" +
                 "      _\n" +
                 "  ___| |__   ___  ___ ___\n" +
                 " / __| |_ \\ / _ \\/ __/ __|\n" +
                 "| (__| | | |  __/\\__ \\__ \\\n" +
                 " \\___|_| |_|\\___||___/___/\n"+

                   "          ____    _   __   __ _____\n" +
                   "         / ___|  / \\  |  \\/  |  ___|\n" +
                   "        | |  _  / _ \\ | |\\/| |  _|\n" +
                   "        | |_| |/ ___ \\| |  | | |___\n" +
                   "         \\____/_/   \\_\\ |  |_|_____|\n"+
                        " \n       "

        );
    }


    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" - - -  La partie est lancé - - -");

        //boucle while gagnant =>true/false
        while (true) {
            joueur1.setJoue(true);
            joueur2.setJoue(true);
            //boucle while tour j1 =>true/false
            while (joueur1.isJoue()) {

                System.out.println("Cest à votre tour de jouer");
                //System.out.println("Quel piece voulez vous déplacer ? ");
                //scanner.next();
                // System.out.println("Cest aux blanc de jouer");

                System.out.println("Ligne de la piece deplacer ?");
                int ligne_piece_a_deplacer = scanner.nextInt();
                System.out.println("Colonne de la piece deplacer ?");
                int colonne_piece_a_deplacer = scanner.nextInt();

                Pion pion_a_deplacer = (Pion) plateau.terrain[colonne_piece_a_deplacer][ligne_piece_a_deplacer].getPiece();
                //pion_a_deplacer.deplacement_possibles(plateau);
                //parcourir la tab de deplacement possible !!
                ArrayList<Case> temp = pion_a_deplacer.deplacement_possibles(plateau);
                if(temp.isEmpty()){
                    System.out.println("PROBLEME");
                }
                for (Case c : temp){
                    System.out.println("test des liste de case");
                    System.out.println(c.getPosColonne() + ":" + c.getPosLigne());
                }

                if (pion_a_deplacer == null) {
                    System.out.println("La case selectionnee est vide");
                } else {
                    joueur1.setJoue(!pion_a_deplacer.avancer(plateau));
                }
                //code...
                //récupère si déplacement ou manger renvoie true


            }
            plateau.printPlateauSchema();
            //boucle while tour j2 =>true/false
            while (joueur2.isJoue()) {

                System.out.println("Cest aux noirs de jouer");
                System.out.println("Ligne de la piece deplacer ?");
                int ligne_piece_a_deplacer = scanner.nextInt();
                System.out.println("Colonne de la piece deplacer ?");
                int colonne_piece_a_deplacer = scanner.nextInt();

                Pion pion_a_deplacer = (Pion) plateau.terrain[colonne_piece_a_deplacer][ligne_piece_a_deplacer].getPiece();
                System.out.println("Vous avez selectionné" + pion_a_deplacer.getNom());

                if (pion_a_deplacer == null) {
                    System.out.println("La case selectionnee est vide");
                } else {
                    joueur2.setJoue(!pion_a_deplacer.avancer(plateau));
                }
            }

            //plateau.printPlateauTexte();
            plateau.printPlateauSchema();
        }
    }
}
