package main;

import main.affichage.AffichageTerrain;
import main.outils.OutilsTableaux;

import static main.Constantes.VALEUR_OBSTACLE;
import static main.Constantes.VALEUR_PIEGE;

public class Personnages {

	private static int _vie = 3;
	private static int _maxVie = 3;

	public static int recupererVie() {
		return _vie;
	}

	public static void modifierVie(int nbVie) {
		int nbVies = _vie + nbVie;
		if(nbVies > _maxVie) {
			nbVies = _maxVie;
		} else if (nbVies < 0) {
			nbVies = 0;
		}

		_vie = nbVies;
	}

	public static int recuperMaxVie() {
		return _maxVie;
	}


	/**
	 * Renvoie un booléen qui valide ou non le déplacement dans la direction donnée.
	 * 
	 * @param direction	direction du déplacement du personnage, caractère 'g', 'd', 'b' ou 'h'
	 * @param position	position actuelle du personnage, tableau de longueur 2 de type [ligne, colonne]
	 * @return			Booléen, true si le déplacement est valide, false sinon
	 */
	public static boolean deplacementPossible(char direction, int[] position) {
		int[][] terrain = Terrain.recupererTerrain();
		return (OutilsTableaux.valeurCaseACote(terrain, direction, position) == 0);
	}
	
	/**
	 * Déplace le personnage de une case par rapport à sa position et à la direction donnée.
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

		int ancienneValeur = terrain[posLigne][posColonne];

		terrain[posLigne][posColonne] = 0;

		switch(direction) {
		case 'g':
			posColonne -= 1;
			break;
		case 'd':
			posColonne += 1;
			break;
		case 'b':
			posLigne +=1;
			break;
		case 'h':
			posLigne -= 1;
			break;
		}

		terrain[posLigne][posColonne] = ancienneValeur;
		//AffichageTerrain.afficher();
		return new int[] {posLigne, posColonne};
	}
	

}
