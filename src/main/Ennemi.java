package main;

import main.outils.Chemin;
import main.outils.OutilsEntites;
import main.outils.OutilsTableaux;

import java.util.ArrayList;
import java.util.List;

import static main.Constantes.VALEUR_JOUEUR;

public class Ennemi {

	private static int[] tabEnnemis = {10,11};
	
    public static void effectuerTourEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();
        int[] positionJoueur = Joueur.positionJoueur();
        int[][] cheminAParcourir = Chemin.trouverChemin(Terrain.recupererTerrain());
        Chemin.afficherTableau(cheminAParcourir);


        //On récupère tout les ennemis pour éviter que la boucle répertorie plusieurs fois le même ennemi
        ArrayList<int[]> toutLesEnnemis = OutilsEntites.recupererToutesLesPositionEnnemis();


        for(int indexEnnemi = 0; indexEnnemi < toutLesEnnemis.size(); indexEnnemi++) {
        	System.out.println();
            //System.out.println(terrain[toutLesEnnemis.get(indexEnnemi)[0]][toutLesEnnemis.get(indexEnnemi)[1]]);
            System.out.println(String.format("Ennemi n°%s/%s ", (indexEnnemi+1), toutLesEnnemis.size()));
            int[] ennemi = toutLesEnnemis.get(indexEnnemi);
            int typeEnnemi = terrain[ennemi[0]][ennemi[1]];
            switch(typeEnnemi) {
            case Constantes.VALEUR_TAUREAU:
            	System.out.println(String.format("Tour taureau [%s][%s]", ennemi[0], ennemi[1]));
            	break;
            case Constantes.VALEUR_ARCHER:
            	System.out.println(String.format("Tour archer[%s][%s]", ennemi[0], ennemi[1]));
            	break;
            }
            int casesRestantes = cheminAParcourir[ennemi[0]][ennemi[1]];


            //System.out.println(String.format("Je veux afficher le x et le y, ils sont égaux à [%s][%s]", ennemi[0], ennemi[1]));


            char[] directionValide = {'d', 'g', 'h', 'b'};
            short indiceDirection = 0;
            boolean estDeplace = false;
            boolean aAttaque = false;
            int valeurEnnemi = terrain[ennemi[0]][ennemi[1]];
            
            switch (valeurEnnemi) {
	            case Constantes.VALEUR_TAUREAU:
	                //System.out.println("Distance " + OutilsEntites.distanceEntreDeux(positionJoueur, ennemi));
	                if (OutilsEntites.distanceEntreDeux(positionJoueur, ennemi) == 1) {
	                    char directionJoueur = OutilsEntites.recupererOrientation(ennemi, positionJoueur);
	                    Competences.charge(directionJoueur, ennemi);
	                    System.out.println("Chargez !");
	                    aAttaque = true;
	                }
	                break;
	            case Constantes.VALEUR_ARCHER:
	            	if (Competences.tirArc(ennemi)) {
	            		System.out.println("ca attaque !");
	            		aAttaque = true;
	            	}
	                break;
	            default:
	                break;
            }
            System.out.println("attaque: " + aAttaque);
            //Le joueur est à la position 1, donc si c'est égale à deux, cela signifie qu'il à côté
            //C'est légèrement plus rapide que de faire appel à Outils.distanceEntreDeux
            if(cheminAParcourir[ennemi[0]][ennemi[1]] != 2 && !aAttaque) {
                //System.out.println("Je me situe à " + casesRestantes +  " je vais donc me déplacer");
                while (indiceDirection < directionValide.length && !estDeplace) {
                    char directionActuelle = directionValide[indiceDirection];

                    int valeurCaseACote = OutilsTableaux.valeurCaseACote(cheminAParcourir, directionActuelle, ennemi);
                    //System.out.println(String.format("a %s il y a %s", directionActuelle, valeurCaseACote));
                    if (valeurCaseACote == casesRestantes - 1) {
                        System.out.println("Je me déplace wéwéwé");
                        if (Personnages.deplacementPossible(directionActuelle, ennemi)) {
                            ennemi = Personnages.deplacementUneCase(directionActuelle, ennemi);
                            estDeplace = true;
                        }
                    }

                    indiceDirection++;
                }
            }
        }


    }

    public static int[] recupererEnnemis() {
    	return tabEnnemis;
    }
}
