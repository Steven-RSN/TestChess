import java.util.ArrayList;
import java.util.Scanner;

public class Lexique {


    public void printAide() {
        System.out.println(
                "                                                \n" +
                        "    --  --  --  --  --  --  HELP  --  --  --  --  --  -- \n" +
                        "  | |                                                  | |\n" +
                        "  | |       jouer               Lance le tour          | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |       --joueurs           Info sur les joueurs   | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |       --plateau           Print le plateau       | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |       --infoPlateau       Info sur le plateau    | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |       --pieces            Liste les pieces       | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |       --partie            Info sur la partie     | |\n" +
                        "  | |                                                  | |\n" +
                        "  | |__   __  __  __  __  __  _  __  __  __  __  __  __| |\n");
    }

    public boolean jouerTour(Partie partie, Scanner scanner) {
        System.out.println("temp !");
        return partie.tourJoueur(scanner);

    }

    ;

    public void joueurInfo(Joueur joueur) {
        System.out.println(
                "Nom: " + joueur.getNom() + " ;" +
                        "Couleur: " + joueur.getCouleur() + " ;" +
                        "Score: " + joueur.getScore() + " ;" +
                        "Tour: " + joueur.isJoue() + " ;"
        );

    }


    public void printPlateau(Plateau plateau) {
        plateau.printPlateauSchema();
    }

    public void printInfoPlateau(Plateau plateau) {
        plateau.printPlateauTexte();

    }

    ;

    public void infoPieces(Plateau plateau) {

        ArrayList<Pieces> piecesNoir = new ArrayList<>();
        ArrayList<Pieces> piecesBlanche = new ArrayList<>();
        for (int i = 0; i < plateau.getLigneMax(); i++) {
            System.out.println("   ");

            for (int j = 0; j < plateau.getColonneMax(); j++) {
                if (!plateau.terrain[j][i].getStatus()) {
                    continue;
                }
                Pieces p = plateau.terrain[j][i].getPiece();

                if (p.getCouleur().equals("Noir") && p.getEnJeux()) {
                    piecesNoir.add(p);
                } else if (p.getCouleur().equals("Blanc") && p.getEnJeux()) {
                    piecesBlanche.add(p);
                }
            }

        }

        System.out.println("Pièces Blanches encore en jeu: ");
        for (Pieces piece : piecesBlanche) {
            System.out.println(

                    "Type: " + piece.getUnicode() +"   "/* piece.getType() + ";  "*/ +
                            "Couleur: " + piece.getCouleur() + "    Position: " + piece.getPosition().getPosColonne() + "-" + piece.getPosition().getPosLigne()
            );

        }
        System.out.println("    ");

        System.out.println("  ");
        System.out.println("Pièces Noires encore en jeu: ");
        for (Pieces piece : piecesNoir) {
            System.out.println(

                    "Type: " + piece.getUnicode() + "   " +/* piece.getType() + ";  " +*/
                            "Couleur: " + piece.getCouleur() + "    Position: " + piece.getPosition().getPosColonne() + "-" + piece.getPosition().getPosLigne()
            );

        }
        System.out.println("    ");

    }


    public void infoParti() {
        System.out.println("info à venir ;)");
    }


}
