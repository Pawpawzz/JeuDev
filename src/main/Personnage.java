package main;

public class Personnage {
	public static boolean deplacementPossible(char direction,double position, int[][] terrain) {
		int posLigne = (int)position;
		int posColonne = (int)(position%1)*10;
		if (direction == 'g')
			if (posColonne-1 < 0)
				return (!(terrain[posLigne][posColonne-1] == 1 || terrain[posLigne][posColonne-1] == 2));
		else if (direction == 'd')
			if (posColonne+1 == terrain.length)
				return (!(terrain[posLigne][posColonne+1] == 1 || terrain[posLigne][posColonne+1] == 2));
		else if (direction == 'b')
			if (posLigne-1 < 0)
				return (!(terrain[posLigne-1][posColonne] == 1 || terrain[posLigne-1][posColonne] == 2));
		else if (direction == 'h')
			if (posLigne+1 == terrain.length)
				return (!(terrain[posLigne+1][posColonne] == 1 || terrain[posLigne+1][posColonne] == 2));
		return false;
	}
}
