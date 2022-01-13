package main.outils;

<<<<<<< Updated upstream
public class OutilsEntites {

=======
import main.Constantes;
import main.Terrain;

import java.util.ArrayList;

public class OutilsEntites {
>>>>>>> Stashed changes
    public static int distanceEntreDeux(int premierePosition[], int secondePosition[]) {
        int distance1 = premierePosition[0] + premierePosition[1];
        int distance2 = secondePosition[0] + secondePosition[1];

        int distanceFinal = distance1 - distance2;

        if(distanceFinal < 0)
            return -distanceFinal;
        else
            return distanceFinal;
    }

    /**
     * Permet de récupérer dans quel direction se situe une position par rapport à une autre,
     * N'est valide que pour les cases côte à côte horizontalement ou verticalement.
     * Retourne 'd' pour droite, 'g' pour gauche, 'h' pour haut, 'b' pour bas, sinon retourne 'n' pour signifié que les cases ne sont pas côte à côte.
     * @param sourcePosition
     * @param ciblePosition
     * @return n, d, g, h, b
     */
    public static char recupererOrientation(int[] sourcePosition, int[] ciblePosition) {
        //n pour null
        if(sourcePosition[0] < ciblePosition[0])
            if (ciblePosition[1] == sourcePosition[1])
                return 'b';

        if(ciblePosition[0] > ciblePosition[0])
            if(ciblePosition[1] == sourcePosition[1])
                return 'h';

        if(sourcePosition[1] > ciblePosition[1])
            if(ciblePosition[0] == sourcePosition[0])
                return 'g';

        if(sourcePosition[1] < ciblePosition[1])
            if(ciblePosition[0] == sourcePosition[0])
                return 'd';

        return 'n';

    }

    public static ArrayList<int[]> recupererToutesLesPositionEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();
        ArrayList<int[]> positionEnnemis = new ArrayList<int[]>();

        for(int caseY = 0; caseY < terrain.length; caseY++) {
            for(int caseX = 0; caseX < terrain.length; caseX++) {
                int valeurCase = terrain[caseY][caseX];
                if(valeurCase >= Constantes.VALEUR_MIN_ENNEMI && valeurCase <= Constantes.VALEUR_MAX_ENNEMI) {
                    int[] positionEnnemi = new int[2];
                    //System.out.println(String.format("J'ai trouvé un ennemi à [%o][%o]", caseY, caseX));
                    positionEnnemi[1] = caseX;
                    positionEnnemi[0] = caseY;
                    positionEnnemis.add(positionEnnemi);
                }
            }
        }

        return positionEnnemis;
    }
}
