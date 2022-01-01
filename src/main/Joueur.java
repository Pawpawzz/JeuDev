package main;

import main.outils.Convertisseur;

public class Joueur {
	/**
	 * Déplace le joueur dans une direction donnée et s'arrête s'il y a un obstacle ou si la longueur donnée est atteinte, 
	 * le tout sur un terrain spécifié
	 */
	public static void deplacement (String directionLongueur) {
		int [][] terrain = Terrain.recupererTerrain();
		int [] position = Joueur.positionJoueur();

		char direction = directionLongueur.charAt(0);
		//Convertir pour prendre en compte les valeurs à deux chiffres
		int longueur = Convertisseur.recupererValeurNumerique(directionLongueur.substring(1));
		int i = 0;

		System.out.println("La longueur est de " + longueur);
		while (Personnages.deplacementPossible(direction, position) && i < longueur) {
			System.out.println("Le déplacement est possible");
			position = Personnages.deplacementUneCase(direction, position);
			i += 1;
		}
	}
	
	public static int[] positionJoueur () {
		int [][] terrain = Terrain.recupererTerrain();
		int[] position = new int[2];
		
		for (int ligne = 0; ligne < terrain.length; ligne ++)
			for (int colonne = 0; colonne < terrain.length; colonne++)
				if (terrain[ligne][colonne] == 5) {
					position[0] = ligne;
					position[1] = colonne;
					return position;
				}
		System.out.println("[ERREUR] Le joueur ne se trouve pas sur le plateau");
		return position;
	}

}
