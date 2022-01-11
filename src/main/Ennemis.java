package main;

import main.outils.Chemin;
import main.outils.OutilsEntites;

import java.util.ArrayList;
import java.util.List;

import static main.Constantes.VALEUR_JOUEUR;

public class Ennemis {

	private static int[] tabEnnemis = {10,11};
	
    public static void effectuerTourEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();

        int[] positionJoueur = Joueur.positionJoueur();

        int[][] cheminAParcourir = Chemin.trouverChemin(Terrain.recupererTerrain());
        Chemin.afficherTableau();


        //On récupère tout les ennemis pour éviter que la boucle répertorie plusieurs fois le même ennemi
        ArrayList<int[]> toutLesEnnemis = recupererToutesLesPositionEnnemis();


        for(int indexEnnemi = 0; indexEnnemi < toutLesEnnemis.size(); indexEnnemi++) {
            //System.out.println(terrain[toutLesEnnemis.get(indexEnnemi)[0]][toutLesEnnemis.get(indexEnnemi)[1]]);
            System.out.println(String.format("Ennemi n°%s/%s", (indexEnnemi+1), toutLesEnnemis.size()));
            int[] ennemi = toutLesEnnemis.get(indexEnnemi);

            int positionY = ennemi[0];
            int positionX = ennemi[1];

            boolean aEteDeplacer = false;

            int caseY = 0;

            while(caseY < cheminAParcourir.length && !aEteDeplacer) {
                int caseX = 0;
                while(caseX < cheminAParcourir.length && !aEteDeplacer) {
                    int[] positionCheminActuelle = {caseY, caseX};
                    if(OutilsEntites.distanceEntreDeux(ennemi, positionCheminActuelle) == 1 && terrain[caseY][caseX] == 0) {

                        if(cheminAParcourir[caseY][caseX] == cheminAParcourir[ennemi[0]][ennemi[1]] - 1) {
                            char direction = OutilsEntites.recupererOrientation(ennemi, positionCheminActuelle);
                            System.out.println("Je peux me déplacer vers " + direction);
                            Personnages.deplacementUneCase(direction, ennemi);
                            aEteDeplacer = true;
                        }
                    }


                    caseX++;
                }
                caseY++;
            }
            System.out.println("Je vérifie si je peux attaquer");
        }



    }

    public static ArrayList<int[]> recupererToutesLesPositionEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();
        ArrayList<int[]> positionEnnemis = new ArrayList<int[]>();

        for(int caseY = 0; caseY < terrain.length; caseY++) {
            for(int caseX = 0; caseX < terrain.length; caseX++) {
                int valeurCase = terrain[caseY][caseX];
                if(valeurCase >= Constantes.VALEUR_MIN_ENNEMI && valeurCase <= Constantes.VALEUR_MAX_ENNEMI) {
                    int[] positionEnnemi = new int[2];
                    System.out.println(String.format("J'ai trouvé un ennemi à [%o][%o]", caseY, caseX));
                    positionEnnemi[1] = caseX;
                    positionEnnemi[0] = caseY;
                    positionEnnemis.add(positionEnnemi);
                }
            }
        }

        return positionEnnemis;
    }
    
    public static int[] recupererEnnemis() {
    	return tabEnnemis;
    }
}
