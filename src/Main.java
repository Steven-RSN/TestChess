
void main() {

    //TODO :
    // Créer la class Lexique/commandes ?

    //Creation du plateau (matrice de Case)
    Plateau plateau = new Plateau();

    //Info Joueur
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nom du joueur qui joue les Blanc :");
    String j1Nom = scanner.next();
    System.out.println("Nom du joueur qui joue les Noir");
    String j2Nom = scanner.next();

    //Creation des joueur
    Joueur j1 = new Joueur(j1Nom, "Blanc");
    Joueur j2 = new Joueur(j2Nom, "Noir");

    //Creer & lance la partie
    Partie partie = new Partie(j1, j2,plateau);
    partie.initPartie();
    partie.logo();
    partie.placerPieces();

    plateau.printPlateauTexte();
    partie.lancerPartie();




    /*
    Charset utf8Charset = Charset.forName("UTF-8");
    Charset defaultCharset = Charset.defaultCharset();
    System.out.println(defaultCharset);

    //Unicode: PionNoir / PionBlanc !!
    String unicodeMessage = "\u2659\u265F";

    ///mais quelle dinguerie !!
    System.out.println(unicodeMessage);
    */


}
