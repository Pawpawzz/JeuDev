package main;

public class Personnage {
	/**
	 * Renvoie un bool�en qui valide ou non le d�placement dans la direction donn�e.
	 * 
	 * @param direction	direction du d�placement du joueur, caract�re 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du joueur, double de type (x.y)
	 * @param terrain	tableau � 2 dimensions carr�
	 * @return			Bool�en, true si le d�placement est valide, false sinon
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
	 * D�place le joueur de une case par rapport � sa position et � la direction donn�e, le tout sur un terrain sp�cifi�
	 * Attention: Ne v�rifie pas la validit� du d�placement avant de d�placer le joueur
	 * 
	 * @param direction	direction du d�placement du joueur, caract�re 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du joueur, double de type (x.y)
	 * @param terrain	tableau � 2 dimensions carr�
	 */
	public static void deplacement (char direction, double position, int[][]terrain) {
		int posLigne = (int)position;
		int posColonne = (int)(position%1)*10;
		switch(direction) {
		case 'g':
			terrain[posLigne][posColonne-1] = 5;
			break;
		case 'd':
			terrain[posLigne][posColonne+1] = 5;
			break;
		case 'b':
			terrain[posLigne-1][posColonne] = 5;
			break;
		case 'h':
			terrain[posLigne+1][posColonne] = 5;
			break;
		}
		terrain[posLigne][posColonne] = 0;
	}
	
	
	
//	public static void main(String[] args) {
//		System.out.println(deplacementPossible('z', 2.1, Terrain.genererTerrain(10)));
//	}
}
