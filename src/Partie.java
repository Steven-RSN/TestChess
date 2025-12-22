import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;
    //private Regles regles;
    Lexique lexique = new Lexique();

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

    public void placerPieces2() {

        for (int i = 0; i < plateau.getColonneMax(); i++) {
            Case casePionN = plateau.terrain[i][plateau.getLigneMax() - 1];
            Tour tourN = new Tour("Np" + (i + 1), "Noir", casePionN, "♖");
            casePionN.setPiece(tourN);
            casePionN.setStatus(true);

            Case casePionB = plateau.terrain[i][0];
            Tour tourB = new Tour("Bp" + (i + 1), "Blanc", casePionB, "♜");
            casePionB.setPiece(tourB);
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
                "       _\n" +
                        "    __|\\_\\     __   ___ ___ \n" +
                        "   / __\\| |_\\ /\\__\\/\\__\\___\\ \n" +
                        "  / / __|  _ \\ / _ \\/ __/ __|\n" +
                        "  | | (_| | | |  __/\\__ \\__ \\\n" +
                        "    \\___|_| |_|\\___||___/___/\n" +

                        "            ___     _   ___  __ ____\n" +
                        "           / ___\\  /\\\\ |\\__\\|\\__\\____\\\n" +
                        "          / / ___|/ / \\| |  \\/  |  ___|\n" +
                        "         | | |  _/ / _ \\ |      |  _|\n" +
                        "         | | |_| |/ ___ \\| |\\/| | |___\n" +
                        "            \\____/_/   \\_\\_|  |_|_____|\n"
        );
    }

    public boolean tourJoueur(Joueur joueur ,Scanner scanner) {
        System.out.println("- C'est à " + joueur.getNom() + " (" + joueur.getCouleur() + ") de jouer");
        Pieces piecesChoisi = joueur.selectionPiece(scanner, plateau);

        if (piecesChoisi == null || !piecesChoisi.getCouleur().equals(joueur.getCouleur())) {
            System.out.println("- Vous n'avez pas de pièce à cet endroit");
            return true;
        }
        ArrayList<Case> temp;
        System.out.println(piecesChoisi.getType());

        temp = (ArrayList<Case>) piecesChoisi.deplacement_possibles(plateau);


        ArrayList<String> deplacementTab = new ArrayList<>();
        if (temp.isEmpty()) {
            System.out.println("Aucun déplacement possible pour cette pièce !");
        } else {
            System.out.println("Déplacements possibles :");

            for (Case c : temp) {
                System.out.println(c.getPosColonne() + "-" + c.getPosLigne());
                deplacementTab.add(c.getPosColonne() + "-" + c.getPosLigne());
            }
        }

        System.out.println("- Indiquez les coordonée de déplacement: colonne-ligne ou taper annuler");
        String futureCase = scanner.next().trim();

        if (futureCase.equals("annuler")) {
            return true;
        } else if (deplacementTab.contains(futureCase)) {
            System.out.println("Déplacement ok !");
            String[] parts = futureCase.split("-");
            int colSaisie = Integer.parseInt(parts[0]);
            int ligSaisie = Integer.parseInt(parts[1]);
            piecesChoisi.avancerColLine(colSaisie, ligSaisie, plateau);
            joueur.setJoue(false);
            return false;

        } else {
            System.out.println("- Déplacement invalide !!");
            return true;
        }
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  ");
        System.out.println("- - - - - - |   *  La partie est lancé  *   | - - - - - -");
        System.out.println("  ");
        plateau.printPlateauSchema();
        System.out.println("  ");

        // commandes joueur 1
        Map<String, Runnable> commandesJ1 = new HashMap<>();
        commandesJ1.put("--help", () -> lexique.printAide());
        commandesJ1.put("jouer", () -> tourJoueur(joueur1, scanner));
        commandesJ1.put("--joueur", () -> lexique.joueurInfo(joueur1));
        commandesJ1.put("--plateau", () -> lexique.printPlateau(plateau));
        commandesJ1.put("--infoPlateau", () -> lexique.printInfoPlateau(plateau));
        commandesJ1.put("--pieces", () -> lexique.infoPieces(plateau));
        commandesJ1.put("--partie", () -> lexique.infoParti());

        // commandes joueur 2
        Map<String, Runnable> commandesJ2 = new HashMap<>();
        commandesJ2.put("--help", () -> lexique.printAide());
        commandesJ2.put("jouer", () -> tourJoueur(joueur2, scanner));
        commandesJ2.put("--joueur", () -> lexique.joueurInfo(joueur2));
        commandesJ2.put("--plateau", () -> lexique.printPlateau(plateau));
        commandesJ2.put("--infoPlateau", () -> lexique.printInfoPlateau(plateau));
        commandesJ2.put("--pieces", () -> lexique.infoPieces(plateau));
        commandesJ2.put("--partie", () -> lexique.infoParti());

        //boucle while gagnant =>true/false
        while (true) {
            try {
                joueur1.setJoue(true);
                joueur2.setJoue(true);

                //boucle while tour j1 =>true/false
                while (joueur1.isJoue()) {
                    System.out.println("- Tapez jouer pour lancer votre tour.       / tapez --help  ");
                    String actionJoueur = scanner.next();

                    if (commandesJ1.containsKey(actionJoueur)) {
                        commandesJ1.get(actionJoueur).run();
                    } else {
                        System.out.println("Commande inconnue.");
                    }

                }

                plateau.printPlateauSchema();

                //boucle while tour j2 =>true/false
                while (joueur2.isJoue()) {
                    System.out.println("- Tapez jouer pour lancer votre tour.       / tapez --help  ");
                    String actionJoueur = scanner.next();

                    if (commandesJ2.containsKey(actionJoueur)) {
                        commandesJ2.get(actionJoueur).run();
                    } else {
                        System.out.println("Commande inconnue.");
                    }
                }

                    /*
                    System.out.println("C'est à " + joueur2.getNom() + " (" + joueur2.getCouleur() + ") de jouer");
                    System.out.println("Colonne de la piece deplacer ?");
                    int colonne_piece_a_deplacer = scanner.nextInt();
                    System.out.println("Ligne de la piece deplacer ?");
                    int ligne_piece_a_deplacer = scanner.nextInt();

                    Pion pion_a_deplacer = (Pion) plateau.terrain[colonne_piece_a_deplacer][ligne_piece_a_deplacer].getPiece();
                    System.out.println("Vous avez selectionné" + pion_a_deplacer.getNom());

                    if (pion_a_deplacer == null) {
                        System.out.println("La case selectionnee est vide");
                    } else {
                        joueur2.setJoue(!pion_a_deplacer.avancer(plateau));
                    }*/


                plateau.printPlateauSchema();
            } catch (Exception e) {
                throw new NullPointerException();
            }
        }
    }
}






/*--------------------------------------------------------------------------------------------------------------------
                    System.out.println("C'est à " + joueur1.getNom() + " (" + joueur1.getCouleur() + ") de jouer");
                    Pieces piecesChoisi = joueur1.selectionPiece(scanner, plateau);
                    if (piecesChoisi == null || !piecesChoisi.getCouleur().equals(joueur1.getCouleur())) {
                        System.out.println("Vous n'avez pas de pièce à cet endroit");
                        continue;
                    }

                    ArrayList<Case> temp = piecesChoisi.deplacement_possibles(plateau);

                    ArrayList<String> deplacementTab = new ArrayList<>();
                    for (Case c : temp) {
                        System.out.println(c.getPosColonne() + ":" + c.getPosLigne());
                        deplacementTab.add(c.getPosColonne() + "-" + c.getPosLigne());
                    }

                    System.out.println("Indiquez les coordonée de déplacement: colonne-ligne ou taper annuler");
                    String futureCase = scanner.next().trim();

                    if (futureCase.equals("annuler")) {
                        continue;
                    } else if (deplacementTab.contains(futureCase)) {
                        System.out.println("Déplacement ok !");
                        String[] parts = futureCase.split("-");
                        int colSaisie = Integer.parseInt(parts[0]);
                        int ligSaisie = Integer.parseInt(parts[1]);
                        piecesChoisi.avancerColLine(colSaisie, ligSaisie, plateau);
                        joueur1.setJoue(false);

                    } else {
                        System.out.println("Déplacement invalide !!");
                    }
                /*
                System.out.println("Ligne de la piece deplacer ?");
                int ligne_piece_a_deplacer = scanner.nextInt();
                System.out.println("Colonne de la piece deplacer ?");
                int colonne_piece_a_deplacer = scanner.nextInt();
                Pion pion_a_deplacer = (Pion) plateau.terrain[colonne_piece_a_deplacer][ligne_piece_a_deplacer].getPiece();

                if (pion_a_deplacer == null || ) {
                    System.out.println("La case selectionnee est vide");
                } else {
                    joueur1.setJoue(!pion_a_deplacer.avancer(plateau));
                }*/

//code...
//récupère si déplacement ou manger renvoie true
