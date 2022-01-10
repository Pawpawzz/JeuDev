package main.outils;

import static main.Constantes.VALEUR_MIN_ENNEMI;

public class Chemin {
    static int[][] _terrainParcours;
    public static void main(String[] args) {
        int dimension = 100;

        
        
        int[][] terrain = new int[dimension][dimension];

        //Position joueur
        terrain[3][5] = 1;
        terrain[1][1] = 1;
        terrain[2][2] = 1;

        terrain[50][50] = 5;

        trouverChemin(terrain);
        afficherTableau();
    }

    public static void afficherTableau() {
        for(int x = 0; x < _terrainParcours.length; x++) {
            for(int y = 0; y < _terrainParcours.length; y++) {
                System.out.print(_terrainParcours[x][y]+"\t");
            }
            System.out.println();
        }
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
        _terrainParcours = new int[dimension][dimension];

        int nombreDeCases = dimension * dimension;

        for (int nbCase = 0; nbCase < nombreDeCases; nbCase++) {
            //System.out.println("Nombre de cases " + nombreDeCases);
            for (int x = 0; x < _terrainParcours.length; x++) {
                for (int y = 0; y < _terrainParcours.length; y++) {

                    int valeur = tabReferenciel[x][y];

                    if (valeur == 5) {
                        _terrainParcours[x][y] = 1;

                    }

                    if (_terrainParcours[x][y] != 0) {
                        int[] positionActuelle = {x, y};
                        remplirAutour(positionActuelle, tabReferenciel);

                    }
                }
            }
        }

        return _terrainParcours;
    }

    public static void remplirAutour(int[] position, int[][] tabReferenciel) {
        int x = position[0];
        int y = position[1];

        int nombreDeCasesRemplis = 0;
        int valActuelle = _terrainParcours[x][y];

        if(x + 1 < _terrainParcours.length) {
            if (_terrainParcours[x + 1][y] == 0) {
                if (tabReferenciel[x + 1][y] == 0 || tabReferenciel[x + 1][y] >= VALEUR_MIN_ENNEMI) {
                    _terrainParcours[x + 1][y] = valActuelle + 1;
                } else {
                    _terrainParcours[x + 1][y] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }

        if(x - 1 >= 0) {
            if (_terrainParcours[x - 1][y] == 0) {
                if (tabReferenciel[x - 1][y] == 0 || tabReferenciel[x - 1][y] >= VALEUR_MIN_ENNEMI) {
                    _terrainParcours[x - 1][y] = valActuelle + 1;
                } else {
                    _terrainParcours[x - 1][y] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }


        if(y + 1 < _terrainParcours.length) {
            if (_terrainParcours[x][y + 1] == 0) {
                if (tabReferenciel[x][y + 1] == 0 || tabReferenciel[x][y + 1] >= VALEUR_MIN_ENNEMI) {
                    _terrainParcours[x][y + 1] = valActuelle + 1;
                } else {
                    _terrainParcours[x][y + 1] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }

        if(y -1 >=0) {
            if (_terrainParcours[x][y - 1] == 0) {
                if (tabReferenciel[x][y - 1] == 0 || tabReferenciel[x][y - 1] >= VALEUR_MIN_ENNEMI) {
                    _terrainParcours[x][y - 1] = valActuelle + 1;
                } else {
                    _terrainParcours[x][y - 1] = -1; //C'est un obstacle, on lui assigne -1
                }
            }
        }
    }
}
