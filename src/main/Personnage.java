package main;

public class Personnage {

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
	 * @param direction	direction du déplacement du joueur, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du joueur, double de type (x.y)
	 * @param terrain	tableau à 2 dimensions carré
	 * @return			Booléen, true si le déplacement est valide, false sinon
	 */
	public static boolean deplacementPossible(char direction, double position, int[][] terrain) {
		int posLigne = (int)position;
		int posColonne = (int)(position%1)*10;
		switch(direction) {
		case 'g':
			if (posColonne-1 < 0)
				return (!(terrain[posLigne][posColonne-1] == 1 || terrain[posLigne][posColonne-1] == 2));
			break;
		case 'd':
			if (posColonne+1 == terrain.length)
				return (!(terrain[posLigne][posColonne+1] == 1 || terrain[posLigne][posColonne+1] == 2));
			break;
		case 'b':
			if (posLigne-1 < 0)
				return (!(terrain[posLigne-1][posColonne] == 1 || terrain[posLigne-1][posColonne] == 2));
			break;
		case 'h':
			if (posLigne+1 == terrain.length)
				return (!(terrain[posLigne+1][posColonne] == 1 || terrain[posLigne+1][posColonne] == 2));
			break;
		}
		return false;
	}
	
	/**
	 * Déplace le joueur de une case par rapport à sa position et à la direction donnée, le tout sur un terrain spécifié
	 * Attention: Ne vérifie pas la validité du déplacement avant de déplacer le joueur
	 * 
	 * @param direction	direction du déplacement du joueur, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du joueur, double de type (x.y)
	 * @param terrain	tableau à 2 dimensions carré
	 */
	public static void deplacement (char direction, double position, int[][]terrain) {
		int posLigne = (int)position;
		int posColonne = (int)(position%1)*10;
		switch(direction) {
		case 'g':
			terrain[posLigne][posColonne-1] = terrain[posLigne][posColonne];
			break;
		case 'd':
			terrain[posLigne][posColonne+1] = terrain[posLigne][posColonne];
			break;
		case 'b':
			terrain[posLigne-1][posColonne] = terrain[posLigne][posColonne];
			break;
		case 'h':
			terrain[posLigne+1][posColonne] = terrain[posLigne][posColonne];
			break;
		}
		terrain[posLigne][posColonne] = 0;
	}
	
	
	
//	public static void main(String[] args) {
//		System.out.println(deplacementPossible('z', 2.1, Terrain.genererTerrain(10)));
//	}
}
