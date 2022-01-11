package main;

public class Competences {

    public static void charge(char direction, int[] position) {
        int [][] terrain = Terrain.recupererTerrain();/

        //On vérifie si la prochaine case est un ennemi
        int prochainCase = Terrain.valeurCaseACote(direction, position);

        if(prochainCase >= Constantes.VALEUR_MIN_ENNEMI && prochainCase <= Constantes.VALEUR_MAX_ENNEMI) {
            int[] posEnnemi = Terrain.positionCaseACote(direction, position);
            int[] prochainePosition = Terrain.positionCaseACote(direction, posEnnemi);

            while(Terrain.valeurCaseACote(direction, posEnnemi) == 0) {
                terrain[prochainePosition[0]][prochainePosition[1]] = terrain[posEnnemi[0]][posEnnemi[1]];

                terrain[posEnnemi[0]][posEnnemi[1]] = 0;

                posEnnemi = prochainePosition;
                prochainePosition = Terrain.positionCaseACote(direction, posEnnemi);
            }

            if(prochainePosition[0] != 1 && prochainePosition[1] != -1) {
                if (Terrain.valeurCaseACote(direction, posEnnemi) == Constantes.VALEUR_PIEGE) {
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
}
