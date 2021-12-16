package main.terrain;

public class AffichageTerrain {
    final static int LARGEUR_CASE = 6;
    final static int HAUTEUR_CASE = 3;



    public static void main (String[] args) {
        String[][] map = {
                {"1", " ", "1"},
                {" ", "♣", " "},
                {" ", " ", " "},
                {" ", " ", " "},
                {"2", "●", "d"}};

        for(int ligne = 0; ligne < map.length; ligne++) {
            afficherCasesEnLigne(map[ligne].length, map.length, ligne, map);
        }

    }

    /**
     *
     * @param maxLargeur Longueur de la carte
     * @param maxHauteur Hauteur de la carte
     * @param ligneActuelle la ligne contenant les données à traiter
     * @param carte Pour récupérer les caractères à afficher
     */
    public static void afficherCasesEnLigne(int maxLargeur, int maxHauteur, int ligneActuelle, String[][] carte) {

        int supprimerLigne = 0;

        //Pour que les cases s'emboîte, il faut modifié les caractères de la première et la dernière case
        if(ligneActuelle % maxHauteur != 0) {
            supprimerLigne = 1;
        }

        for(int ligne = supprimerLigne; ligne < HAUTEUR_CASE; ligne++) {
            for(int colonne = 0; colonne <= LARGEUR_CASE * maxLargeur; colonne++) {
                int colonneActuelle = colonne%LARGEUR_CASE;
                switch(ligne) {
                    case 0: //La première ligne
                        switch (colonneActuelle) {
                            case 0:
                                if(colonne == 0)
                                    System.out.print("┌");
                                else if(colonne == LARGEUR_CASE * maxLargeur)
                                    System.out.print("┐");
                                else
                                    System.out.print("┬");
                                break;


                            default:
                                System.out.print("─");
                                break;
                        }
                        break;
                    case HAUTEUR_CASE -1: //La dernière ligne
                        if (colonneActuelle == 0) {
                            if (colonne == 0)
                                //Le cas ou c'est la première colonne
                                if(ligne + ligneActuelle -1 == maxHauteur) //On enlève 1 comme on commence à zéro
                                    System.out.print("└");
                                else
                                    System.out.print("├");

                            else if (colonne == LARGEUR_CASE * maxLargeur)
                                if(ligne + ligneActuelle -1 == maxHauteur) //On enlève 1 comme on commence à zéro
                                    System.out.print("┘");
                                else
                                    System.out.print("┤");
                            else
                                if(ligne + ligneActuelle -1 == maxHauteur) //On enlève 1 comme on commence à zéro
                                    System.out.print("┴");
                                else
                                    System.out.print("┼");
                        } else {
                            System.out.print("─");
                        }
                        break;
                    default: //Toutes les autres lignes

                        if(colonne % LARGEUR_CASE == 0)
                            System.out.print("│");
                        else if((colonne % LARGEUR_CASE) == LARGEUR_CASE / 2)
                            //Permet de récupérer l'emplacement de la case
                            System.out.print(carte[ligne + ligneActuelle-1][(colonne / maxLargeur)/2]);
                        else
                            //On affiche du vide à côté des cases
                            System.out.print(" ");

                        break;
                }

            }
            System.out.println();

            //System.out.println();
        }
    }
    public static void afficherTerrain(int[][] terrain) {
        for (int ligne = 0; ligne < terrain.length; ligne++) {
            for (int colonne = 0; colonne < terrain.length; colonne++) {
                if (terrain[ligne][colonne] != 0)
                    System.out.print(terrain[ligne][colonne]);
                else
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
    }
}

/*
0 1 2 3
0┌─────┬───
1│  £  │
2└─────┼───
*/

