
void main(String[] args) {

    //Creation du plateau (matrice de Case)
    Plateau plateau = new Plateau();

    //Info Joueurs
    Scanner scanner = new Scanner(System.in);
    System.out.println("- Nom du joueur qui joue les Blancs :");
    String j1Nom = scanner.next();
    System.out.println("- Nom du joueur qui joue les Noirs");
    String j2Nom = scanner.next();

    //Creation des joueurs
    Joueur j1 = new Joueur(j1Nom, "Blanc");
    Joueur j2 = new Joueur(j2Nom, "Noir");

    //Creer & lance la partie
    Partie partie = new Partie(j1, j2,plateau);
    partie.initPartie();
    partie.logo();
    //partie.placerPieces2();   //- Tour
    partie.placerPieces(); //- Pion
    partie.lancerPartie();






    /*
    Charset utf8Charset = Charsetk.forName("UTF-8");
    Charset defaultCharset = Charset.defaultCharset();
    System.out.println(defaultCharset);

    //Unicode: PionNoir / PionBlanc !!
    String unicodeMessage = "\u2659\u265F";

    ///mais quelle dinguerie !!
    System.out.println(unicodeMessage);
    */


}
