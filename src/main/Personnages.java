package main;

public class Personnages {

	private static int _vie = 3;
	private static int _maxVie = 3;

	public static int recupererVie() {
		return _vie;
	}

	public static int recuperMaxVie() {
		return _maxVie;
	}


	/**
	 * Renvoie un booléen qui valide ou non le déplacement dans la direction donn�e.
	 * 
	 * @param direction	direction du déplacement du personnage, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du personnage, tableau de longueur 2 de type [ligne, colonne]
	 * @return			Booléen, true si le déplacement est valide, false sinon
	 */
	public static boolean deplacementPossible(char direction, int[] position) {
		int[][] terrain = Terrain.recupererTerrain();

		int posLigne = position[0];
		int posColonne = position[1];

		System.out.println("Position joueur x:" + posColonne + " y :" + posLigne);
		System.out.println();
		switch(direction) {
		case 'g':
			if (posColonne-1 >= 0)
				return (terrain[posLigne][posColonne-1] != Terrain.VALEUR_OBSTACLE && terrain[posLigne][posColonne-1] != Terrain.VALEUR_PIEGE);
			break;
		case 'd':
			if (posColonne+1 < terrain.length)
				return (terrain[posLigne][posColonne+1] != Terrain.VALEUR_OBSTACLE && terrain[posLigne][posColonne+1] != Terrain.VALEUR_PIEGE);
			break;
		case 'b':
			if (posLigne+1 < terrain.length)
				return (terrain[posLigne+1][posColonne] != Terrain.VALEUR_OBSTACLE && terrain[posLigne+1][posColonne] != Terrain.VALEUR_PIEGE);
			break;
		case 'h':
			if (posLigne-1 >= 0)
				return (terrain[posLigne-1][posColonne] != Terrain.VALEUR_OBSTACLE && terrain[posLigne-1][posColonne] != Terrain.VALEUR_PIEGE);
			break;
		}
		return false;
	}
	
	/**
	 * Déplace le personnage de une case par rapport à sa position et à la direction donnée, le tout sur un terrain spécifié
	 * Attention: Ne vérifie pas la validité du déplacement avant de déplacer le personnage
	 * 
	 * @param direction	direction du déplacement du personnage, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position du personnage avant le déplacement, tableau de longueur 2 de type [ligne, colonne]
	 * @return positionArrivee	position du personnage après le déplacement, tableau de longueur 2 de type [ligne, colonne]
	 */
	public static int[] deplacementUneCase (char direction, int[] position) {
		int terrain[][] = Terrain.recupererTerrain();

		int posLigne = position[0];
		int posColonne = position[1];
		int[] positionArrivee = {posLigne, posColonne};

		System.out.println("Je me déplace " + direction);
		switch(direction) {
		case 'g':
			terrain[posLigne][posColonne-1] = terrain[posLigne][posColonne];
			positionArrivee[1] = posColonne-1;
			break;
		case 'd':
			terrain[posLigne][posColonne+1] = terrain[posLigne][posColonne];
			positionArrivee[1] = posColonne+1;
			break;
		case 'b':
			terrain[posLigne+1][posColonne] = terrain[posLigne][posColonne];
			positionArrivee[0] = posColonne+1;
			break;
		case 'h':
			terrain[posLigne-1][posColonne] = terrain[posLigne][posColonne];
			positionArrivee[0] = posColonne-1;
			break;
		}
		terrain[posLigne][posColonne] = 0;
		
		return positionArrivee;
	}
	

}
