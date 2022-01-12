package main.outils;

import main.Terrain;

public class OutilsTableaux {
    /**
     * Retourne la valeur d'une case se situant à côté d'une autre, il est nécessaire de préciser une direction (d,g,h,b)
     * @param direction
     * @param position
     * @return -1 si la valeur est en dehors des limites du tableau
     */
    public static int valeurCaseACote(int[][] tableau, char direction, int[] position) {
        int valeur = -1;
        switch(direction) {
            case 'g':
                if(position[1] - 1 >= 0)
                    valeur = tableau[position[0]][position[1] - 1];
                break;
            case 'd':
                if(position[1] + 1 < tableau[position[0]].length)
                    valeur = tableau[position[0]][position[1] + 1];
                break;
            case 'h':
                if(position[0] - 1 >= 0)
                    valeur = tableau[position[0] - 1][position[1]];
                break;
            case 'b':
                if(position[0] + 1 < tableau.length)
                    valeur = tableau[position[0] + 1][position[1]];
                break;
        }

        return valeur;
    }

    /**
     * Retourne la position d'une case à côté d'une autre, il est nécessaire de préciser une direction (d,g,h,b)
     * @param direction
     * @param position
     * @return int[-1,-1] si la case est en dehors de la limite
     */
    public static int[] positionCaseACote(int[][] tableau, char direction, int[] position) {
        
        int[] positionACote = {-1, -1};
        switch(direction) {
            case 'g':
                if(position[1] - 1 >= 0) {
                    positionACote[0] = position[0];
                    positionACote[1] = position[1] - 1;
                }
                break;
            case 'd':
                if(position[1] + 1 < tableau[position[0]].length) {
                    positionACote[0] = position[0];
                    positionACote[1] = position[1] + 1;
                }
                break;
            case 'h':
                if(position[0] - 1 >= 0) {
                    positionACote[0] = position[0] - 1;
                    positionACote[1] = position[1];
                }
                break;
            case 'b':
                if(position[0] + 1 < tableau.length) {
                    positionACote[0] = position[0] + 1;
                    positionACote[1] = position[1];
                }
                break;
        }

        return positionACote;
    }

}
