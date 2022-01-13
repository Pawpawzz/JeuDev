package main.outils;

public class OutilsEntites {

    public static void main (String[] args) {
        int[] posUn = {1,1};
        int[] posDeux = {0,0};

        System.out.println(distanceEntreDeux(posUn, posDeux));
        System.out.println(recupererOrientation(posUn, posDeux));

        for(int i = 0; i < 100; i++) {
            //System.out.println("On devrait se diriger vers " + recupererDirection(posUn, posDeux));

        }

    }

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


    public static char[] trouverChemin() {
        char[] chemin = new char[1];
        return chemin;
    }
}
