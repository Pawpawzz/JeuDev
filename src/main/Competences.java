package main;

public class Competences {
    public static void charge(char direction, int[] position) {
        int[][] terrain = Terrain.recupererTerrain();

        int joueurCoordY = position[0];
        int joueurCoordX = position[1];

        int nbCaseX = joueurCoordX;
        int nbCaseY = joueurCoordY;

        boolean aToucher = false;
        //do {
        switch(direction) {
            case 'g':
                if(nbCaseX - 2 >= 0) {
                    int ennemi = terrain[nbCaseY][nbCaseX - 1];
                    nbCaseX--;

                    while(nbCaseX > 0 && !aToucher) {
                        nbCaseX--;
                        int valeurProchainCase = terrain[nbCaseY][nbCaseX];
                        if(valeurProchainCase == Constantes.VALEUR_PIEGE) {
                            terrain[nbCaseY][nbCaseX + 1] = 0;
                            aToucher = true;
                        }
                       else if(valeurProchainCase != 0) {
                            aToucher = true;
                        } else {
                            //On assigne à la case suivante la valeur du personnage
                            terrain[nbCaseY][nbCaseX] = ennemi;
                            //On oublie pas de dire qu'il n'y a plus rien sur cette case
                            terrain[nbCaseY][nbCaseX + 1] = 0;
                        }
                    }
                }
                break;
            case 'd':
                if(nbCaseX + 2 < terrain.length) {
                    int ennemi = terrain[nbCaseY][nbCaseX + 1];
                    nbCaseX++;

                    while(nbCaseX > 0 && !aToucher) {
                        nbCaseX++;
                        int valeurProchainCase = terrain[nbCaseY][nbCaseX];
                        if(valeurProchainCase == Constantes.VALEUR_PIEGE) {
                            terrain[nbCaseY][nbCaseX - 1] = 0;
                            aToucher = true;
                        }
                        else if(valeurProchainCase != 0) {
                            aToucher = true;
                        } else {
                            //On assigne à la case suivante la valeur du personnage
                            terrain[nbCaseY][nbCaseX] = ennemi;
                            //On oublie pas de dire qu'il n'y a plus rien sur cette case
                            terrain[nbCaseY][nbCaseX - 1] = 0;
                        }
                    }
                }

                break;
            case 'h':
                if(nbCaseY - 2 >= 0) {
                    int ennemi = terrain[nbCaseY - 1][nbCaseX];
                    nbCaseY--;

                    while(nbCaseY > 0 && !aToucher) {
                        nbCaseY--;
                        int valeurProchainCase = terrain[nbCaseY][nbCaseX];

                        if(valeurProchainCase == Constantes.VALEUR_PIEGE) {
                            terrain[nbCaseY + 1][nbCaseX] = 0;
                            aToucher = true;
                        }
                        else if(valeurProchainCase != 0) {
                            aToucher = true;
                        } else {
                            //On assigne à la case suivante la valeur du personnage
                            terrain[nbCaseY][nbCaseX] = ennemi;
                            //On oublie pas de dire qu'il n'y a plus rien sur cette case
                            terrain[nbCaseY + 1][nbCaseX] = 0;
                        }
                    }
                }
                break;
            case 'b':
                if(nbCaseY + 2 < terrain.length) {
                    int ennemi = terrain[nbCaseY + 1][nbCaseX];
                    nbCaseY++;

                    while(nbCaseY < terrain.length && !aToucher) {
                        nbCaseY++;
                        int valeurProchainCase = terrain[nbCaseY][nbCaseX];

                        //Si la prochaine case est un piège, alors on fait disparaître l'ennemi
                        if(valeurProchainCase == Constantes.VALEUR_PIEGE) {
                            terrain[nbCaseY - 1][nbCaseX] = 0;
                            aToucher = true;
                        }
                        else if(valeurProchainCase != 0) {
                            aToucher = true;
                        } else {
                            //On assigne à la case suivante la valeur du personnage
                            terrain[nbCaseY][nbCaseX] = ennemi;
                            //On oublie pas de dire qu'il n'y a plus rien sur cette case
                            terrain[nbCaseY - 1][nbCaseX] = 0;
                        }
                    }
                }
                break;
        }

        int valeurCase = terrain[nbCaseY][nbCaseX];
        //} while(nbCaseY > 0 && nbCaseY <= terrain.length && nbCaseX> 0 && nbCaseX <= terrain.length && aToucher);
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

            System.out.println(String.format("CoordY : %s CoordX : %s", nbCaseY, nbCaseX));
            int valeurCase = terrain[nbCaseY][nbCaseX];

            System.out.println("Valeur case " + valeurCase);
            if(valeurCase == Constantes.VALEUR_PIEGE || valeurCase == Constantes.VALEUR_OBSTACLE) {
                aToucher = true;
            }
            else if(valeurCase >= Constantes.VALEUR_MIN_ENNEMI && valeurCase <= Constantes.VALEUR_MAX_ENNEMI) {
                //Pour savoir ou on doit placer l'ennemi en fonction de la direction
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
