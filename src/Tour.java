import java.util.ArrayList;

public class Tour extends Pieces {

    public Tour(String nom, String couleur, Case position, String unicode) {
        super(nom, couleur, true, position, "Tour", unicode);

    }

    public ArrayList<Case> deplacement_possibles(Plateau plateau) {
         ArrayList<Case> deplacements = new ArrayList<>();

        Case currentPos = this.getPosition();
        String couleurTour = this.getCouleur();

        int currentCol = currentPos.getPosColonne();
        int currentLine = currentPos.getPosLigne();

        int maxCol = plateau.getColonneMax();
        int maxLine = plateau.getLigneMax();

       // String[] nomsDirections = {"haut", "bas", "droite", "gauche"};
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int d = 0; d < directions.length; d++) {
            int dc = directions[d][0];
            int dl = directions[d][1];

            int nextCol = currentCol + dc;
            int nextLine = currentLine + dl;

            while (nextCol >= 0 && nextCol < maxCol && nextLine >= 0 && nextLine < maxLine) {
                Case c = plateau.getCase(nextCol, nextLine);

                if (!c.getStatus()) {
                    deplacements.add(c);
                } else {
                    if (!c.getPiece().getCouleur().equals(couleurTour)) {
                        deplacements.add(c);
                    }
                    break;
                }

                nextCol += dc;
                nextLine += dl;
            }
        }

        return deplacements;
    }

    /*public static void printDeplacements2(Map<String, ArrayList<Case>> deplacements) {
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