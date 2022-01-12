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
        ArrayList<int[]> toutLesEnnemis = recupererToutesLesPositionEnnemis();


        for(int indexEnnemi = 0; indexEnnemi < toutLesEnnemis.size(); indexEnnemi++) {
            //System.out.println(terrain[toutLesEnnemis.get(indexEnnemi)[0]][toutLesEnnemis.get(indexEnnemi)[1]]);
            System.out.println(String.format("Ennemi n°%s/%s", (indexEnnemi+1), toutLesEnnemis.size()));
            int[] ennemi = toutLesEnnemis.get(indexEnnemi);
            int casesRestantes = cheminAParcourir[ennemi[0]][ennemi[1]];


            System.out.println(String.format("Je veux afficher le x et le y, ils sont égaux à [%s][%s]", ennemi[0], ennemi[1]));


            char[] directionValide = {'d', 'g', 'h', 'b'};
            short indiceDirection = 0;
            boolean estDeplace = false;
            boolean aAttaque = false;
            int valeurEnnemi = terrain[ennemi[0]][ennemi[1]];
            
            switch (valeurEnnemi) {
	            case Constantes.VALEUR_TAUREAU:
	                System.out.println("Distance " + OutilsEntites.distanceEntreDeux(positionJoueur, ennemi));
	                if (OutilsEntites.distanceEntreDeux(positionJoueur, ennemi) == 1) {
	                    char directionJoueur = OutilsEntites.recupererOrientation(ennemi, positionJoueur);
	                    Competences.charge(directionJoueur, ennemi);
	                    System.out.println("Le joueur se situe à " + directionJoueur);
	                    aAttaque = true;
	                }
	                break;
	            case Constantes.VALEUR_ARCHER:
	            	if (Competences.tirArc(ennemi))
	            		aAttaque = true;
	                break;
	            default:
	                break;
            }
            //Le joueur est à la position 1, donc si c'est égale à deux, cela signifie qu'il à côté
            //C'est légèrement plus rapide que de faire appel à Outils.distanceEntreDeux
            if(cheminAParcourir[ennemi[0]][ennemi[1]] != 2 && !aAttaque) {
                //System.out.println("Je me situe à " + casesRestantes +  " je vais donc me déplacer");
                while (indiceDirection < directionValide.length && !estDeplace) {
                    char directionActuelle = directionValide[indiceDirection];

                    int valeurCaseACote = OutilsTableaux.valeurCaseACote(cheminAParcourir, directionActuelle, ennemi);
                    System.out.println(String.format("a %s il y a %s", directionActuelle, valeurCaseACote));
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

    public static ArrayList<int[]> recupererToutesLesPositionEnnemis() {
        int[][] terrain = Terrain.recupererTerrain();
        ArrayList<int[]> positionEnnemis = new ArrayList<int[]>();

        for(int caseY = 0; caseY < terrain.length; caseY++) {
            for(int caseX = 0; caseX < terrain.length; caseX++) {
                int valeurCase = terrain[caseY][caseX];
                if(valeurCase >= Constantes.VALEUR_MIN_ENNEMI && valeurCase <= Constantes.VALEUR_MAX_ENNEMI) {
                    int[] positionEnnemi = new int[2];
                    //System.out.println(String.format("J'ai trouvé un ennemi à [%o][%o]", caseY, caseX));
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
