package main;

import main.outils.OutilsEntites;

public class Ennemis {

	private static int[] tabEnnemis = {10,11};
	
    public static void effectuerTourEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();

        int[] positionJoueur = Joueur.positionJoueur();

        int nombreEnnemis = 0;
        for(int x = 0; x < terrain.length; x++) {
            for(int y = 0; y < terrain.length; y++) {
                if(terrain[x][y] >= 10 && terrain[x][y] <= 20) { //Les ennemis sont compris entre 10 et 20


                    int[] positionEnnemi = {x, y};
                    char direction = OutilsEntites.recupererDirection(positionEnnemi, positionJoueur);

                    //System.out.println("Position de l'ennemi [" + x + "][" + y + "]" + ", du joueur [" + positionJoueur[0] + "][" + positionJoueur[1] +"]" );

                    System.out.println("Nombre ennemis détectés " + nombreEnnemis + " il doit se diriger vers " + direction);
                    if(Personnages.deplacementPossible(direction, positionEnnemi)) {
                        Personnages.deplacementUneCase(direction, positionEnnemi);
                    }
                }
            }
        }
    }
    
    public static int[] recupererEnnemis() {
    	return tabEnnemis;
    }
}
