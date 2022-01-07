package main.outils;

public class TestAlgo {
    static int[][] terrainParcours;
    public static void main(String[] args) {
        int dimension = 100;
        terrainParcours = new int[dimension][dimension];
        
        
        int[][] terrain = new int[dimension][dimension];

        //Position joueur
        terrain[3][5] = 1;
        terrain[1][1] = 1;
        terrain[2][2] = 1;

        terrain[4][5] = 5;
        calculerTrajectoire(terrain);
        afficherTableau();
    }

    public static void afficherTableau() {
        for(int x = 0; x < terrainParcours.length; x++) {
            for(int y = 0; y < terrainParcours.length; y++) {
                System.out.print(terrainParcours[x][y] - 1+"\t");
            }
            System.out.println();
        }
    }



    public static void calculerTrajectoire(int[][] tabReferenciel) {



       for(int i = 0; i < tabReferenciel.length * tabReferenciel.length; i++) {


            for (int x = 0; x < terrainParcours.length; x++) {
                for (int y = 0; y < terrainParcours.length; y++) {

                    int valeur = tabReferenciel[x][y];

                    if (valeur == 5) {
                        terrainParcours[x][y] = 1;

                    }

                    if (terrainParcours[x][y] != 0) {
                        int[] positionActuelle = {x, y};
                        remplirAutour(positionActuelle, tabReferenciel);

                    }
                }
            }
        }
    }

    public static void remplirAutour(int[] position, int[][] tabReferenciel) {
        int x = position[0];
        int y = position[1];

        int valActuelle = terrainParcours[x][y];

        if(x + 1 < terrainParcours.length)
            if(terrainParcours[x + 1][y] == 0)
                if(tabReferenciel[x + 1][y] == 0)
                    terrainParcours[x + 1][y] = valActuelle + 1;
                else
                    terrainParcours[x + 1][y] = -1; //C'est un obstacle, on lui assigne -1


        if(x - 1 >= 0)
            if(terrainParcours[x - 1][y] == 0)
                if(tabReferenciel[x + 1][y] == 0)
                    terrainParcours[x - 1][y] = valActuelle + 1;
                else
                    terrainParcours[x - 1][y] = -1; //C'est un obstacle, on lui assigne -1



        if(y + 1 < terrainParcours.length)
            if(terrainParcours[x][y + 1] == 0)
                if(tabReferenciel[x][y + 1] == 0)
                    terrainParcours[x][y + 1] = valActuelle+ 1;
                else
                    terrainParcours[x][y + 1] = -1; //C'est un obstacle, on lui assigne -1


        if(y -1 >=0)
            if(terrainParcours[x][y - 1] == 0) {
                if(tabReferenciel[x][y - 1] == 0)
                    terrainParcours[x][y -1] = valActuelle + 1;
                else
                    terrainParcours[x][y -1] = -1; //C'est un obstacle, on lui assigne -1
            }
    }
}
