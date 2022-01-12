package main.outils;

import static main.Constantes.VALEUR_MIN_ENNEMI;

public class Chemin {
    public static void main(String[] args) {
        int dimension = 100;

        
        
        int[][] terrain = new int[dimension][dimension];

        //Position joueur
        terrain[3][5] = 1;
        terrain[1][1] = 1;
        terrain[2][2] = 1;

        terrain[50][50] = 5;

        trouverChemin(terrain);
    }


    public static void afficherTableau(int [][]tableau) {
        for(int x = 0; x < tableau.length; x++) {
            for(int y = 0; y < tableau[x].length; y++) {
                System.out.print(tableau[x][y]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] trouverChemin(int[][] tabReferenciel) {

        int dimension = tabReferenciel.length;
        int[][] terrainParcours = new int[dimension][dimension];

        int nombreDeCases = dimension * dimension;

        for (int nbCase = 0; nbCase < nombreDeCases; nbCase++) {
            //System.out.println("Nombre de cases " + nombreDeCases);
            for (int y = 0; y < terrainParcours.length; y++) {
                for (int x = 0; x < terrainParcours[y].length; x++) {

                    int valeur = tabReferenciel[y][x];

                    if (valeur == 5)
                        terrainParcours[y][x] = 1;

                    if (terrainParcours[y][x] != 0) {
                        int[] positionActuelle = {y, x};
                        remplirAutour(terrainParcours, positionActuelle, tabReferenciel);
                    }
                }
            }
        }

        return terrainParcours;
    }

    public static void remplirAutour(int[][]terrainARemplir, int[] position, int[][] tabReferenciel) {
        int caseX = position[1];
        int caseY = position[0];


        int nombreDeCasesRemplis = 0;
        int valActuelle = terrainARemplir[caseY][caseX];

        if(caseY + 1 < terrainARemplir.length) {
            if (terrainARemplir[caseY + 1][caseX] == 0) {
                if (tabReferenciel[caseY + 1][caseX] == 0 || tabReferenciel[caseY + 1][caseX] >= VALEUR_MIN_ENNEMI) {
                    terrainARemplir[caseY + 1][caseX] = valActuelle + 1;
                } else {
                    terrainARemplir[caseY + 1][caseX] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }

        if(caseY - 1 >= 0) {
            if (terrainARemplir[caseY - 1][caseX] == 0) {
                if (tabReferenciel[caseY - 1][caseX] == 0 || tabReferenciel[caseY - 1][caseX] >= VALEUR_MIN_ENNEMI) {
                    terrainARemplir[caseY - 1][caseX] = valActuelle + 1;
                } else {
                    terrainARemplir[caseY - 1][caseX] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }


        if(caseX + 1 < terrainARemplir.length) {
            if (terrainARemplir[caseY][caseX + 1] == 0) {
                if (tabReferenciel[caseY][caseX + 1] == 0 || tabReferenciel[caseY][caseX + 1] >= VALEUR_MIN_ENNEMI) {
                    terrainARemplir[caseY][caseX + 1] = valActuelle + 1;
                } else {
                    terrainARemplir[caseY][caseX + 1] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }

        if(caseX -1 >=0) {
            if (terrainARemplir[caseY][caseX - 1] == 0) {
                if (tabReferenciel[caseY][caseX - 1] == 0 || tabReferenciel[caseY][caseX - 1] >= VALEUR_MIN_ENNEMI) {
                    terrainARemplir[caseY][caseX - 1] = valActuelle + 1;
                } else {
                    terrainARemplir[caseY][caseX - 1] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }
    }
}
