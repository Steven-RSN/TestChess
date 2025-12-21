import java.util.ArrayList;
import java.util.Map;

public class Pion extends Pieces {
    private String unicode;

    public Pion(String nom, String couleur, Case position, String unicode) {
        super(nom, couleur, true, position, "Pion", unicode);
    }

    //A refactoriser
    public ArrayList<Case> deplacement_possibles(Plateau plateau) {

        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();

        int direction = couleurPion.equals("Noir") ? -1 : +1;
        int nextPosLine = currentPos.getPosLigne() + direction;

        ArrayList<Case> deplacement_possibles = new ArrayList<>();


        if (plateau.terrain[currentPos.getPosColonne()][nextPosLine].getStatus() == false) {
            deplacement_possibles.add(plateau.getCase(currentPos.getPosColonne(), nextPosLine));
        }

        if (currentPos.getPosColonne() + 1 < plateau.getColonneMax()) {
            if (plateau.terrain[currentPos.getPosColonne() + 1][nextPosLine].getStatus() == true &&
                    !plateau.terrain[currentPos.getPosColonne() + 1][nextPosLine].getPiece().getCouleur().equals(couleurPion)) {
                deplacement_possibles.add(plateau.getCase(currentPos.getPosColonne() + 1, nextPosLine));
            }
        }
        if (currentPos.getPosColonne() - 1 >= 0) {

            if (plateau.terrain[currentPos.getPosColonne() - 1][nextPosLine].getStatus() == true &&
                    !plateau.terrain[currentPos.getPosColonne() - 1][nextPosLine].getPiece().getCouleur().equals(couleurPion)) {
                deplacement_possibles.add(plateau.getCase(currentPos.getPosColonne() - 1, nextPosLine));
            }
        }

        return deplacement_possibles;
    }

    public Map<String, ArrayList<Case>> deplacement_possiblesTEMP(Plateau plateau) {
        return null;
    }


    //return True pour terminer le tour, sinon return false
    public Boolean avancer(Plateau plateau) {
        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();
        int direction = couleurPion.equals("Noir") ? -1 : +1;
        int nextPosLine = currentPos.getPosLigne() + direction;

        if (nextPosLine < 0 || nextPosLine >= plateau.getLigneMax()) {
            System.out.println("Vous ne pouvez pas déplacer la pièce en dehors du plateau");
            return false;
        }
        Case nextCase = plateau.terrain[currentPos.getPosColonne()][nextPosLine];

        if (nextCase.getStatus()) {
            System.out.println("La case en face de vous est occupée");
            return false;
        }

        System.out.println("La piece avance");
        // L'ancienne case devient vide
        currentPos.setStatus(false);
        currentPos.setPiece(null);

        // La position du pion change
        this.setPosition(nextCase);

        // La nouvelle case devient occupée
        nextCase.setStatus(true);
        nextCase.setPiece(this);

        //Met fin au tour du joueur
        return true;

    }

    public Boolean avancerColLine(int col, int line , Plateau plateau) {
        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();

        Case nextCase = plateau.terrain[col][line];
        if (nextCase.getStatus() && !nextCase.getPiece().getCouleur().equals(couleurPion)) {
            System.out.println("Vous mangez " + nextCase.getPiece().getType() +' '+ nextCase.getPiece().getCouleur() + " de votre adversaire. ");
            nextCase.getPiece().setEnJeux(false);

        }else if (nextCase.getStatus() && nextCase.getPiece().getCouleur().equals(couleurPion)){
            System.out.println("Une de vos piece se trouve déja sur cette case.");
            return false;
        }

        System.out.println("La piece avance");
        // L'ancienne case devient vide
        currentPos.setStatus(false);
        currentPos.setPiece(null);

        // La position du pion change
        this.setPosition(nextCase);

        // La nouvelle case devient occupée
        nextCase.setStatus(true);
        nextCase.setPiece(this);

        //Met fin au tour du joueur
        return true;

    }

    //TODO:
    // return True pour terminer le tour, sinon return false
    public void manger(Plateau plateau, String direction) {
        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();

        int directionColonneOperateur = direction.equals("Droite") ? +1 : -1;
        int directionOperateur = couleurPion.equals("Noir") ? -1 : +1;
        int nextPosLine = currentPos.getPosLigne() + directionOperateur;
        int nextPosCol = currentPos.getPosColonne() + directionColonneOperateur;

        if (nextPosLine < 0 || nextPosLine >= plateau.getLigneMax() || nextPosCol < 0 || nextPosCol >= plateau.getColonneMax()) {
            System.out.println("Vous ne pouvez pas déplacer la pièce en dehors du plateau");
            return;
        }
        Case nextCase = plateau.terrain[nextPosCol][nextPosLine];

        if (!nextCase.getStatus()) {
            System.out.println("La case colonne :" + nextCase.getPosColonne() + 1 + "ligne :" + nextPosLine + 1 + " de vous n'est pas occupée");
            return;
        }
        System.out.println(' ');

        //Todo:
        // Appeler la méthode getCouleur de la classe Joueur, pour la couleur du joueur adverse
        System.out.println("Votre piece " + this.getNom() + " mange " + nextCase.getPiece().getNom() + " de l'adversaire");
        // L'ancienne case devient vide
        currentPos.setStatus(false);
        currentPos.setPiece(null);

        // La position du pion change
        this.setPosition(nextCase);

        //mange la piece
        nextCase.getPiece().setEnJeux(false);

        // La nouvelle case devient occupée
        nextCase.setStatus(true);
        nextCase.setPiece(this);

    }

}
