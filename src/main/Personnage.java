package main;

public class Personnage {
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
	
//	public static void main(String[] args) {
//		System.out.println(deplacementPossible('z', 2.1, Terrain.genererTerrain(10)));
//	}
}
