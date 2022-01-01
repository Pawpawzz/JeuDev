package main;
public class Joueur {
	/**
	 * Déplace le joueur dans une direction donnée et s'arrête s'il y a un obstacle ou si la longueur donnée est atteinte, 
	 * le tout sur un terrain spécifié
	 * 
	 * @param direction	direction du déplacement du personnage, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position du personnage avant le déplacement, tableau de longueur 2 de type [ligne, colonne]
	 * @param terrain	tableau à 2 dimensions carré
	 */
	public static void deplacement (String directionLongueur, int[] position, int[][]terrain) {
		char direction = directionLongueur.charAt(0);
		int longueur = directionLongueur.charAt(1);
		int i = 0;
		
		
		while (Personnages.deplacementPossible(direction, position, terrain) && i < longueur) {
			position = Personnages.deplacementUneCase(direction, position, terrain);
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
