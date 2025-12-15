//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    //TODO :
    // Créer la class Partie
    // A déplacer dans la class Partie


    //Creation du plateau (matris d'objet Case)
    Plateau plateau = new Plateau();
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
        Pion pionN=new Pion("pionN"+i,"Noir",casePionN);
        casePionN.setPiece(pionN);
        casePionN.setStatus(true);

        Case casePionB=plateau.terrain[i][0];
        Pion pionB =new Pion("pionB"+i,"Blanc",casePionB);
        casePionB.setPiece(pionB);
        casePionB.setStatus(true);
    }


    //test des
    plateau.printPlateauTexte();
    plateau.printPlateauSchema();

    Pion pionBlanc2 = (Pion) plateau.terrain[1][0].getPiece();
    pionBlanc2.avancer(plateau);
    plateau.printPlateauTexte();
    plateau.printPlateauSchema();
    pionBlanc2.avancer(plateau);
  //  pionBlanc1.avancer();
}
