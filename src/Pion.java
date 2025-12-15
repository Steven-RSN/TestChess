public class Pion extends Pieces {
    //private

    public Pion(String nom, String couleur, Case position) {
        super(nom, couleur, true, position, "Pion");

    }

    public void avancer(Plateau plateau) {
        Case currentPos = this.getPosition();
        String couleurPion = this.getCouleur();
        int direction = couleurPion.equals("Noir") ? -1 : +1;
        int nextPosLine = currentPos.getPosLigne() + direction;

        if (nextPosLine < 0 || nextPosLine >= plateau.getLigneMax()) {
            System.out.println("Vous ne pouvez pas déplacer la pièce en dehors du plateau");
            return;
        }
        Case nextCase = plateau.terrain[currentPos.getPosColonne()][nextPosLine];

        if (nextCase.getStatus()) {
            System.out.println("La case en face de vous est occupée");
        } else {
            System.out.println("La piece avance");
            // L'ancienne case devient vide
            currentPos.setStatus(false);
            currentPos.setPiece(null);

            // La position du pion change
            this.setPosition(nextCase);

            // La nouvelle case devient occupée
            nextCase.setStatus(true);
            nextCase.setPiece(this);
        }

    }

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
