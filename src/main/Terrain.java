package main;

public class Terrain {

    public static void placerObstacles(int minObstacles, int maxObstacles, int[][] terrain) {
    	System.out.println(minObstacles + "" + maxObstacles);
    	for (int i = 0; i < (int)(Math.random()*((maxObstacles - minObstacles) + 1) + minObstacles); i++) {
    		terrain[(int) (Math.random()*terrain.length)][(int) (Math.random()*terrain.length)] = 1;
    	}
    }

    public static void placerPieges(int minPieges, int maxPieges, int[][] terrain) {
    	for (int i = 0; i < (int)(Math.random()*((maxPieges - minPieges) + 1) + minPieges); i++) {
    		terrain[(int) (Math.random()*terrain.length)][(int) (Math.random()*terrain.length)] = 2;
    	}
    }

    public static int[][] genererTerrain(int longueur) {
        int [][] nouveauTerrain = new int[longueur][longueur];

        
        placerObstacles((int)(0.4*(double)longueur),(int)((double)longueur), nouveauTerrain);
        placerPieges((int)(0.7*(double)longueur),(int)(1.2*(double)longueur), nouveauTerrain);

        return nouveauTerrain;
    }
    
    public static void afficherTerrain(int[][] terrain) {
    	for (int i = 0; i < terrain.length; i++) {
    		for (int j = 0; j < terrain.length; j++) {
    			if (terrain[i][j] != 0)
    				System.out.print(terrain[i][j]);
    			else
    				System.out.print(" ");
    			System.out.print("|");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
		afficherTerrain(genererTerrain(20));

	}
}