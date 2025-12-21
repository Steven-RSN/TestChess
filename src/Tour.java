import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tour extends Pieces {

    public Tour(String nom, String couleur, Case position, String unicode) {
        super(nom, couleur, true, position, "Tour", unicode);

    }

    @Override
    public Map<String, ArrayList<Case>> deplacement_possiblesTEMP(Plateau plateau) {
        return Map.of();
    }
    public ArrayList<Case> deplacement_possibles(Plateau plateau) {
        return null;
    }

    /*
        public ArrayList<Case> deplacement_possibles(Plateau plateau) {

            Case currentPos = this.getPosition();
            String couleurPion = this.getCouleur();
            DeplacementPossibleCol(currentPos.getPosColonne())
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
    /*
        public ArrayList<Integer> DeplacementPossibleCol(int col){
            int colActuel=col;
            ArrayList<Integer> colPositive=

            return
        }
    */
    /*
    public Map<String,ArrayList<Case>> deplacement_possibles(Plateau plateau) {
        Map<String, ArrayList<Case>> deplacements = new HashMap<>();

        Case currentPos = this.getPosition();
        String couleurTour = this.getCouleur();

        int currentCol = currentPos.getPosColonne();
        int currentLine = currentPos.getPosLigne();

        int maxCol = plateau.getColonneMax();
        int maxLine = plateau.getLigneMax();

        String[] nomsDirections = {"haut", "bas", "droite", "gauche"};
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int d = 0; d < directions.length; d++) {
            int dc = directions[d][0];
            int dl = directions[d][1];

            ArrayList<Case> casesDirection = new ArrayList<>();

            int nextCol = currentCol + dc;
            int nextLine = currentLine + dl;

            while (nextCol >= 0 && nextCol < maxCol && nextLine >= 0 && nextLine < maxLine) {
                Case c = plateau.getCase(nextCol, nextLine);

                if (!c.getStatus()) {
                    casesDirection.add(c);
                } else {
                    if (!c.getPiece().getCouleur().equals(couleurTour)) {
                        casesDirection.add(c);
                    }
                    break;
                }

                nextCol += dc;
                nextLine += dl;
            }

            deplacements.put(nomsDirections[d], casesDirection);
        }

        return deplacements;
    }

    public static void printDeplacements2(Map<String, ArrayList<Case>> deplacements) {
        for (String direction : deplacements.keySet()) {
            ArrayList<Case> cases = deplacements.get(direction);

            if (cases.isEmpty()) {
                System.out.println(direction + ": []");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(direction).append(": [");
                for (int i = 0; i < cases.size(); i++) {
                    Case c = cases.get(i);
                    sb.append(c.getPosColonne()).append("-").append(c.getPosLigne());
                    if (i < cases.size() - 1) sb.append(" -> ");
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }*/

}