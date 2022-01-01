package main;

public class Terrain {
    public final static int VALEUR_OBSTACLE = 1;
    public final static int VALEUR_PIEGE = 2;

    private static int [][] _terrain;

    public static void placerObstacles(int minObstacles, int maxObstacles) {
    	for (int nbObstacle = 0; nbObstacle < (int)(Math.random()*((maxObstacles - minObstacles) + 1) + minObstacles); nbObstacle++) {
    		_terrain[(int) (Math.random()*_terrain.length)][(int) (Math.random()*_terrain.length)] = 1;
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
        int[][] terrain = Terrain.recupererTerrain();

    	int[] position = {(int) (Math.random()*terrain.length),(int) (Math.random()*terrain.length)};
    	while (terrain[position[0]][position[1]] != 0)
			position[0] = (int) (Math.random()*terrain.length);
			position[1] = (int) (Math.random()*terrain.length);
		terrain[position[0]][position[1]] = 5;
    }

    public static void genererTerrain(int longueur) {
        _terrain = new int[longueur][longueur];


        placerObstacles((int)(0.4*(double)longueur),(int)((double)longueur));
        placerPieges((int)(0.7*(double)longueur),(int)(1.2*(double)longueur));
        placerJoueur();

    }

    public static int[][] recupererTerrain() {
        return _terrain;
    }



    
    /*public static void main(String[] args) {
		afficherTerrain(genererTerrain(20));

	}*/
}