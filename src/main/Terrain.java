package main;

import static main.Constantes.VALEUR_OBSTACLE;
import static main.Constantes.VALEUR_PIEGE;

public class Terrain {


    private static int [][] _terrain;

    public static void placerObstacles(int minObstacles, int maxObstacles) {
    	for (int nbObstacle = 0; nbObstacle < (int)(Math.random()*((maxObstacles - minObstacles) + 1) + minObstacles); nbObstacle++) {
    		_terrain[(int) (Math.random()*_terrain.length)][(int) (Math.random()*_terrain.length)] = VALEUR_OBSTACLE;
    	}
    }


    public static void placerPieges(int minPieges, int maxPieges) {
    	for (int nbPiege = 0; nbPiege < (int)(Math.random()*((maxPieges - minPieges) + 1) + minPieges); nbPiege++) {
    		_terrain[(int) (Math.random()*_terrain.length)][(int) (Math.random()*_terrain.length)] = VALEUR_PIEGE;
    	}
    }
    
    public static void placerEnnemis(int[] tabEnnemis) {
    	for (int Ennemi: tabEnnemis) {
    		int[] position = {(int) (Math.random()*_terrain.length),(int) (Math.random()*_terrain.length)};
    		while (_terrain[position[0]][position[1]] != 0)
    			position[0] = (int) (Math.random()*_terrain.length);
    			position[1] = (int) (Math.random()*_terrain.length);
            _terrain[position[0]][position[1]] = Ennemi;
    	}
    }
    
    public static void placerJoueur () {

    	int[] position = {(int) (Math.random()*_terrain.length),(int) (Math.random()*_terrain.length)};
    	while (_terrain[position[0]][position[1]] != 0) {
			position[0] = (int) (Math.random()*_terrain.length);
			position[1] = (int) (Math.random()*_terrain.length);
    	}
		_terrain[position[0]][position[1]] = 5;
    }

    public static void genererTerrain(int longueur, boolean vide) {
        _terrain = new int[longueur][longueur];


        if(!vide) {
            placerObstacles((int) (0.4 * (double) longueur), (int) ((double) longueur));
            placerPieges((int) (0.7 * (double) longueur), (int) (1.2 * (double) longueur));
            placerEnnemis(Ennemis.recupererEnnemis());
            placerJoueur();
        }
    }

    /**
     * Retourne la valeur d'une case se situant à côté d'une autre, il est nécessaire de préciser une direction (d,g,h,b)
     * @param direction
     * @param position
     * @return -1 si la valeur est en dehors des limites du tableau
     */
    public static int valeurCaseACote(char direction, int[] position) {
        int valeur = -1;
        switch(direction) {
            case 'g':
                if(position[1] - 1 >= 0)
                    valeur = _terrain[position[0]][position[1] - 1];
                break;
            case 'd':
                if(position[1] + 1 < _terrain[position[0]].length)
                    valeur = _terrain[position[0]][position[1] + 1];
                break;
            case 'h':
                if(position[0] - 1 >= 0)
                    valeur = _terrain[position[0] - 1][position[1]];
                break;
            case 'b':
                if(position[0] + 1 < _terrain.length)
                    valeur = _terrain[position[0] + 1][position[1]];
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
    public static int[] positionCaseACote(char direction, int[] position) {
        int[][] terrain = Terrain.recupererTerrain();

        int[] positionACote = {-1, -1};
        switch(direction) {
            case 'g':
                if(position[1] - 1 >= 0) {
                    positionACote[0] = position[0];
                    positionACote[1] = position[1] - 1;
                }
                break;
            case 'd':
                if(position[1] + 1 < terrain[position[0]].length) {
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
                if(position[0] + 1 < terrain.length) {
                    positionACote[0] = position[0] + 1;
                    positionACote[1] = position[1];
                }
                break;
        }

        return positionACote;
    }

    public static int[][] recupererTerrain() {
        return _terrain;
    }



    
    /*public static void main(String[] args) {
		afficherTerrain(genererTerrain(20));

	}*/
}