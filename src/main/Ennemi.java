package main;

import main.outils.Chemin;
import main.outils.OutilsEntites;
import main.outils.OutilsTableaux;
import main.affichage.AffichagePersonnages;

import java.util.ArrayList;

public class Ennemi {

	private static int[] tabEnnemis = {10,11};
	
    public static void effectuerTourEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();

        int[] positionJoueur = Joueur.positionJoueur();

        int[][] cheminAParcourir = Chemin.trouverChemin(Terrain.recupererTerrain());


        //On récupère tout les ennemis pour éviter que la boucle répertorie plusieurs fois le même ennemi
        ArrayList<int[]> toutLesEnnemis = recupererToutesLesPositionEnnemis();


        for(int indexEnnemi = 0; indexEnnemi < toutLesEnnemis.size(); indexEnnemi++) {
            int[] ennemi = toutLesEnnemis.get(indexEnnemi);
            int typeEnnemi = terrain[ennemi[0]][ennemi[1]];
            int casesRestantes = cheminAParcourir[ennemi[0]][ennemi[1]];

            char[] directionValide = {'d', 'g', 'h', 'b'};
            short indiceDirection = 0;
            boolean estDeplace = false;
            boolean aAttaque = false;
            int valeurEnnemi = terrain[ennemi[0]][ennemi[1]];
            
            switch (valeurEnnemi) {
	            case Constantes.VALEUR_TAUREAU:
	                if (OutilsEntites.distanceEntreDeux(positionJoueur, ennemi) == 1) {
	                    char directionJoueur = OutilsEntites.recupererOrientation(ennemi, positionJoueur);
	                    Competences.charge(directionJoueur, ennemi);
	                    aAttaque = true;
	                }
	                break;
	            case Constantes.VALEUR_ARCHER:
	            	if (Competences.tirArc(ennemi)) {
	            		aAttaque = true;
	            	}
	                break;
	            default:
	                break;
            }
            //Le joueur est à la position 1, donc si c'est égale à deux, cela signifie qu'il à côté
            //C'est légèrement plus rapide que de faire appel à Outils.distanceEntreDeux
            if(cheminAParcourir[ennemi[0]][ennemi[1]] != 2 && !aAttaque) {
                while (indiceDirection < directionValide.length && !estDeplace) {
                    char directionActuelle = directionValide[indiceDirection];

                    int valeurCaseACote = OutilsTableaux.valeurCaseACote(cheminAParcourir, directionActuelle, ennemi);
                    if (valeurCaseACote == casesRestantes - 1) {
                        if (Personnages.deplacementPossible(directionActuelle, ennemi)) {
                            ennemi = Personnages.deplacementUneCase(directionActuelle, ennemi);
                            estDeplace = true;
                        }
                    }

                    indiceDirection++;
                }
            }
            switch(typeEnnemi) {
            case Constantes.VALEUR_TAUREAU:
            	System.out.println(String.format("Tour taureau [%s][%s]", ennemi[0], ennemi[1]));
            	break;
            case Constantes.VALEUR_ARCHER:
            	System.out.println(String.format("Tour archer[%s][%s]", ennemi[0], ennemi[1]));
            	break;
            }
            AffichagePersonnages.afficherAction(aAttaque);
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
