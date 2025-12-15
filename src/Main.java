//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    //TODO :
    // Créer la class Partie
    // A déplacer dans la class Partie


    //Creation du plateau (matris d'objet Case)
    Plateau plateau = new Plateau();
    Scanner scanner = new Scanner(System.in);
    //initJoueur(Scanner);
    System.out.println("Nom joueur1 :");
    String j1Nom = scanner.next();
    System.out.println("Votre couleur : 'Blanc' / 'Noir' :");
    String j1Couleur = scanner.next();
    System.out.println("Nom joueur2 :");


    String j2Couleur;
    if (j1Couleur.equals("Blanc")) {
        j2Couleur = "Noir";
    } else {
        j2Couleur = "Blanc";
    }
    String j2Nom = scanner.next();
    Joueur j1 = new Joueur(j1Nom, j1Couleur);
    Joueur j2 = new Joueur(j2Nom, j2Couleur);

    Partie partie = new Partie(j1, j2,plateau);
    partie.initPartie();
    partie.placerPieces();


  /*
    for (int i = 0; i < plateau.getColonneMax(); i++) {

        for (int j = 0; j < plateau.getLigneMax(); j++) {
            String couleur;
            if ((i+j) % 2 == 0) {
                couleur = "Blanc";

            } else {
                couleur = "Noir";
            }

            Case currentCase = new Case(couleur, i, j);
            plateau.terrain[i][j] = currentCase;
        }
    }


    //Future methode de la class Partie pour placer les pions
    for(int i =0 ; i<plateau.getColonneMax();i++) {
        Case casePionN=plateau.terrain[i][plateau.getLigneMax()-1];
        Pion pionN=new Pion("pionN"+(i+1),"Noir",casePionN);
        casePionN.setPiece(pionN);
        casePionN.setStatus(true);

        Case casePionB=plateau.terrain[i][0];
        Pion pionB =new Pion("pionB"+(i+1),"Blanc",casePionB);
        casePionB.setPiece(pionB);
        casePionB.setStatus(true);
    }
*/

    //test
    plateau.printPlateauTexte();
    plateau.printPlateauSchema();

    Pion pionBlanc2 = (Pion) plateau.terrain[1][2].getPiece();
    pionBlanc2.avancer(plateau);
    plateau.printPlateauTexte();
    plateau.printPlateauSchema();
    pionBlanc2.avancer(plateau);
    pionBlanc2.manger(plateau, "Droite");
    plateau.printPlateauSchema();

    //  pionBlanc1.avancer();
}
/*
public void initJoueur(sc){
    System.out.println("Nom joueur1 :");
    String j1Nom = sc.next();
    System.out.println("Votre couleur : 'Blanc' / 'Noir' :");
    String j1Couleur = sc.next();
    System.out.println("Nom joueur2 :");
}
*/