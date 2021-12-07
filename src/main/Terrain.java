package main;

public class Terrain {

    public static void placerObstacles(int minObstacles, int maxObstacles, int[][] terrain) {

    }

    public static void placerPieges(int minPieges, int maxPieges, int[][] terrain) {

    }

    public static int[][] GenererTerrain(int longueur) {
        int [][] nouveauTerrain = new int[longueur][longueur];


        placerObstacles(1,2, nouveauTerrain);
        placerPieges(1,2, nouveauTerrain);

        return nouveauTerrain;
    }
}