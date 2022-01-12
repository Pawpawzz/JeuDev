package main;

import main.outils.OutilsTableaux;

public class Competences {

    public static void charge(char direction, int[] position) {
        int [][] terrain = Terrain.recupererTerrain();

        //On vérifie si la prochaine case est un ennemi
        int prochainCase = OutilsTableaux.valeurCaseACote(terrain, direction, position);

        if((prochainCase >= Constantes.VALEUR_MIN_ENNEMI && prochainCase <= Constantes.VALEUR_MAX_ENNEMI) || prochainCase == Constantes.VALEUR_JOUEUR) {
            int[] posEnnemi = OutilsTableaux.positionCaseACote(terrain, direction, position);
            int[] prochainePosition = OutilsTableaux.positionCaseACote(terrain, direction, posEnnemi);

            while(OutilsTableaux.valeurCaseACote(terrain, direction, posEnnemi) == 0) {
                terrain[prochainePosition[0]][prochainePosition[1]] = terrain[posEnnemi[0]][posEnnemi[1]];

                terrain[posEnnemi[0]][posEnnemi[1]] = 0;

                posEnnemi = prochainePosition;
                prochainePosition = OutilsTableaux.positionCaseACote(terrain, direction, posEnnemi);
            }

            if(prochainePosition[0] != 1 && prochainePosition[1] != -1) {
                if (OutilsTableaux.valeurCaseACote(terrain, direction, posEnnemi) == Constantes.VALEUR_PIEGE) {
                    System.out.println("On tue l'ennemi");
                    terrain[posEnnemi[0]][posEnnemi[1]] = 0;
                }
            }
        }
    }

    public static void grappin(char direction, int[] position) {
        int[][] terrain = Terrain.recupererTerrain();

        int joueurCoordY = position[0];

        int joueurCoordX = position[1];
        //On part de la position actuelle pour lancer le grappin
        int nbCaseX = joueurCoordX;
        int nbCaseY = joueurCoordY;

        System.out.println(String.format("Position joueur %s %s", joueurCoordY, joueurCoordX ));
        boolean aToucher = false;
        boolean piege = false;

        do {
            switch (direction) {
                case 'd':
                    nbCaseX++;
                    break;
                case 'g':
                    nbCaseX--;
                    break;

                case 'h':
                    nbCaseY--;
                    break;

                case 'b':
                    nbCaseY++;
                    break;
            }

            //System.out.println(String.format("CoordY : %s CoordX : %s", nbCaseY, nbCaseX));
            int valeurCase = terrain[nbCaseY][nbCaseX];

            System.out.println("Valeur case " + valeurCase);
            if(valeurCase == Constantes.VALEUR_OBSTACLE) {
                aToucher = true;
            }
            
            if (valeurCase == Constantes.VALEUR_PIEGE) {
            	piege = true;
            }
            
            else if(valeurCase >= Constantes.VALEUR_MIN_ENNEMI && valeurCase <= Constantes.VALEUR_MAX_ENNEMI) {
                //Pour savoir ou on doit placer l'ennemi en fonction de la direction
            	if (!piege)
	                switch(direction) {
	                    case 'd':
	                        terrain[joueurCoordY][joueurCoordX + 1] = valeurCase;
	                        break;
	                    case 'g':
	                        terrain[joueurCoordY][joueurCoordX -1] = valeurCase;
	                        break;
	                    case 'h':
	                        terrain[joueurCoordY - 1][joueurCoordX] = valeurCase;
	                        break;
	                    case 'b':
	                        terrain[joueurCoordY + 1][joueurCoordX] = valeurCase;
	                        break;
	                }

                terrain[nbCaseY][nbCaseX] = 0;
                aToucher = true;
            }

        } while(nbCaseX > 0 && nbCaseX < terrain.length && nbCaseY > 0 && nbCaseY < terrain.length && !aToucher);
    }
    
    public static void saut(char direction, int[] position) {
    	int[][] terrain = Terrain.recupererTerrain();
    	switch(direction) {
        case 'd':
            if (position[1]+2 < terrain.length && terrain[position[0]][position[1]+2] == 0) {
            	terrain[position[0]][position[1]+2] = Constantes.VALEUR_JOUEUR;
            	terrain[position[0]][position[1]] = 0;
            }
            break;
        case 'g':
        	 if (position[0]-2 >= 0 && terrain[position[0]-2][position[1]] == 0) {
             	terrain[position[0]][position[1]+2] = Constantes.VALEUR_JOUEUR;
             	terrain[position[0]][position[1]] = 0;
        	}
            break;
        case 'h':
        	if (position[0]-2 < terrain.length && terrain[position[0]-2][position[1]] == 0) {
            	terrain[position[0]-2][position[1]] = Constantes.VALEUR_JOUEUR;
            	terrain[position[0]][position[1]] = 0;
        	}
            break;
        case 'b':
        	if (position[0]+2 >= 0 && terrain[position[0]+2][position[1]] == 0) {
            	terrain[position[0]+2][position[1]] = Constantes.VALEUR_JOUEUR;
            	terrain[position[0]][position[1]] = 0;
        	}
            break;
    	}
    }
    
    /**
	 * Renvoie un booléen, true si l'archer attaque, false sinon.
	 * Attention: les méthodes qui suivent servent et fonctionnent uniquement pour l'archer
	 * 
	 * @param posTireur	position actuelle de l'archer, tableau de longueur 2 de type [ligne, colonne]
	 * @return			booléen
	 */
    public static boolean tirArc (int[] posTireur) {
    	int[] posJoueur = Joueur.positionJoueur();
    	char direction;
    	
    	if (posTireur[0] == posJoueur[0])
    		direction = tirDirection(posTireur, posJoueur, 'x');
    	else if (posTireur[1] == posJoueur[1])
    		direction = tirDirection(posTireur, posJoueur, 'y');
    	else
    		return false;
		if (peutTirer(posTireur, posJoueur, direction)) {
			System.out.println("L'archer tire, vous perdez une vie");
			Personnages.modifierVie(-1);
			return true;
		}
    	return false;
    }
    
    /**
	 * Renvoie un booléen, true si il n'y a pas d'obstacles entre l'archer et le joueur, false sinon.
	 * 
	 * @param posTireur	position actuelle de l'archer, tableau de longueur 2 de type [ligne, colonne]
	 * @param posJoueur	position actuelle du joueur, tableau de longueur 2 de type [ligne, colonne]
	 * @param direction	charactère qui définit dans quelle direction l'archer doit attaquer, 'h', 'b', 'd' ou 'g'
	 * @return			booléen
	 */
    public static boolean peutTirer (int[] posTireur, int[] posJoueur, char direction) {
    	int [][] terrain = Terrain.recupererTerrain();
    	int x;
    	int y;
    	
    	switch(direction) {
		case 'g':
			x = posTireur[1]-1;
			while ((terrain[posTireur[0]][x] == 0 || terrain[posTireur[0]][x] == Constantes.VALEUR_PIEGE) && x != posJoueur[1]) {
				x--;
			}
			return x == posJoueur[1];
		case 'd':
			x = posTireur[1]+1;
			while ((terrain[posTireur[0]][x] == 0 || terrain[posTireur[0]][x] == Constantes.VALEUR_PIEGE) && x != posJoueur[1]) {
				x++;
			}
			return x == posJoueur[1];
		case 'h':
			y = posTireur[0]-1;
			while ((terrain[y][posTireur[1]] == 0 || terrain[y][posTireur[1]] == Constantes.VALEUR_PIEGE) && y != posJoueur[0]) {
				y--;
			}
			return y == posJoueur[0];
		case 'b':
			y = posTireur[0]+1;
			while ((terrain[y][posTireur[1]] == 0 || terrain[y][posTireur[1]] == Constantes.VALEUR_PIEGE) && y != posJoueur[0]) {
				y++;
			}
			return y == posJoueur[0];
    	}
    	return false;
    	
    }
    /**
	 * Renvoie un charactère qui définit la direction dans laquelle l'archer doit tirer, par rapport au joueur.
	 * 
	 * @param posTireur	position actuelle de l'archer, tableau de longueur 2 de type [ligne, colonne]
	 * @param posJoueur	position actuelle du joueur, tableau de longueur 2 de type [ligne, colonne]
	 * @param axe		charactère qui définit sur quel axe sont alignés le joueur et l'archer, 'x' ou 'y'
	 * @return			charactère, 'h', 'b', 'd' ou 'g'
	 */
    public static char tirDirection (int[] posTireur, int[] posJoueur, char axe) {
    	if (axe == 'y') {
    		if (posTireur[0] < posJoueur[0])
    			return 'b';
    		else
    			return 'h';
    	}
    	else {
    		if (posTireur[1] < posJoueur[1])
    			return 'd';
    		else
    			return 'g';
    	}
    }
    
    
}
