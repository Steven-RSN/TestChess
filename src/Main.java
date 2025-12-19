//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    //TODO :
    // Créer la class Lexique/commandes -> interagire avec le jeu!


    //Bloc a garder et a integrer a l'affichage !!!!
    Charset utf8Charset = Charset.forName("UTF-8");
    Charset defaultCharset = Charset.defaultCharset();
    System.out.println(defaultCharset);

    //Unicode: PionNoir / PionBlanc !!
    String unicodeMessage = "\u2659\u265F";

    ///mais quelle dinguerie !!
    System.out.println(unicodeMessage);





    //Creation du plateau (matrice d'objet Case)
    Plateau plateau = new Plateau();
    Scanner scanner = new Scanner(System.in);
    //initJoueur(Scanner);
    System.out.println("Nom joueur1 :");
    String j1Nom = scanner.next();
    System.out.println("Votre couleur : 'Blanc' / 'Noir' :");

    String j1Couleur = scanner.next();
 //   while (!j1Couleur.equals("Blanc") || !j1Couleur.equals("Noir")){

  //  }

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
    partie.logo();
    partie.placerPieces();


    //test
    plateau.printPlateauTexte();
   // plateau.printPlateauSchema();
    partie.lancerPartie();
    /*
    Pion pionBlanc2 = (Pion) plateau.terrain[1][2].getPiece();
    pionBlanc2.avancer(plateau);
    plateau.printPlateauTexte();
    plateau.printPlateauSchema();
    pionBlanc2.avancer(plateau);
    pionBlanc2.manger(plateau, "Droite");
    plateau.printPlateauSchema();

    //  pionBlanc1.avancer();*/
}
