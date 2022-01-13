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
        ArrayList<int[]> toutLesEnnemis = OutilsEntites.recupererToutesLesPositionEnnemis();


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

                    System.out.println(String.format("Tour taureau[%s][%s]", ennemi[0], ennemi[1]));
	                if (cheminAParcourir[ennemi[0]][ennemi[1]] == 2) {

                        char directionJoueur = OutilsEntites.recupererOrientation(ennemi, positionJoueur);
	                    Competences.charge(directionJoueur, ennemi);
	                    aAttaque = true;
	                }
	                break;
	            case Constantes.VALEUR_ARCHER:
                    System.out.println(String.format("Tour archer[%s][%s]", ennemi[0], ennemi[1]));
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

            AffichagePersonnages.afficherAction(aAttaque);
        }


    }
    
    public static int[] recupererEnnemis() {
    	return tabEnnemis;
    }
}
