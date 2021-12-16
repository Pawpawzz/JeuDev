package main;

public class Terrain {




    public static void placerObstacles(int minObstacles, int maxObstacles, int[][] terrain) {
    	for (int nbObstacle = 0; nbObstacle < (int)(Math.random()*((maxObstacles - minObstacles) + 1) + minObstacles); nbObstacle++) {
    		terrain[(int) (Math.random()*terrain.length)][(int) (Math.random()*terrain.length)] = 1;
    	}
    }

    public static void placerPieges(int minPieges, int maxPieges, int[][] terrain) {
    	for (int nbPiege = 0; nbPiege < (int)(Math.random()*((maxPieges - minPieges) + 1) + minPieges); nbPiege++) {
    		terrain[(int) (Math.random()*terrain.length)][(int) (Math.random()*terrain.length)] = 2;
    	}
    }

    public static int[][] genererTerrain(int longueur) {
        int [][] nouveauTerrain = new int[longueur][longueur];

        
        placerObstacles((int)(0.4*(double)longueur),(int)((double)longueur), nouveauTerrain);
        placerPieges((int)(0.7*(double)longueur),(int)(1.2*(double)longueur), nouveauTerrain);

        return nouveauTerrain;
    }
    

    
    /*public static void main(String[] args) {
		afficherTerrain(genererTerrain(20));

	}*/
}