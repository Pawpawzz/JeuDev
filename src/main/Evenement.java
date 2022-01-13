package main;

import main.affichage.AffichageTerrain;

public class Evenement {
	private static int [][] terrainEvenement;
	
	public static void main(String[] args) {
		terrainEvenement = new int[15][15];
		
		evenementCarréHaché();
		
		afficherTableau();
	}
	
	public static void afficherTableau() {
        for(int x = 0; x < terrainEvenement.length; x++) {
            for(int y = 0; y < terrainEvenement.length; y++) {
                System.out.print(terrainEvenement[x][y] +"\t");
            }
            System.out.println();
        }
    }
	
    public static void genererUnEvenement() {
    	copieTerrainVide();
    	
    	int nEvenement =  (int)(Math.random()*4)+1;
    	System.out.println("Event n°" + nEvenement);
    	
    	switch(nEvenement) {
    		case 1:
    			evenementCroix();
    			break;
    		case 2:
    			evenementCercle();
    			break;
    		case 3:
    			evenementUneCaseSurTrois();
    			break;
    		case 4:
    			evenementCarréHaché();
    			break;
    	}
    }
    
    public static void copieTerrainVide() {
    	int[][] temp = Terrain.recupererTerrain();
    	terrainEvenement = new int[temp.length][temp.length];
    }
    
    public static void evenementCroix() {
    	for (int ligne = 0; ligne < terrainEvenement.length; ligne++) {
    		terrainEvenement[ligne][terrainEvenement.length/2] = 42;
    	}
    	for (int colonne = 0; colonne < terrainEvenement.length; colonne++) {
    		terrainEvenement[terrainEvenement.length/2][colonne] = 42;
    	}
    }

    public static void evenementCercle() {
    	 
    }
    
    public static void evenementUneCaseSurTrois() {
    	for (int ligne = 0; ligne < terrainEvenement.length; ligne++) {
    		for (int colonne = 0; colonne < terrainEvenement.length; colonne++) {
    			if (colonne%3 == 0)
    				terrainEvenement[ligne][colonne] = 42;
    		}
    	}
    }
    
    public static void evenementCarréHaché() { //et non pas steak haché
    	for (int ligne = 1; ligne < terrainEvenement.length-1; ligne++) {
    		if (ligne%(terrainEvenement.length/4) != 0)
    			for (int colonne = 1; colonne < terrainEvenement.length-1; colonne++) {
    				terrainEvenement[ligne][colonne] = 42;
    		}
    	}
         
    }
    
    public static int[][] recupererTerrain() {
    	return terrainEvenement;
    }
   
    public static void afficherEvent() {
        for(int ligne = 0; ligne < terrainEvenement.length; ligne++) {
            AffichageTerrain.afficherCasesEnLigne(terrainEvenement[ligne].length, terrainEvenement.length, ligne, terrainEvenement);
        }
    }
    
    public static boolean joueurDanger() {
    	int[] posJoueur = Joueur.positionJoueur();
    	return terrainEvenement[posJoueur[0]][posJoueur[1]] == 42;
    }
    
    public static void debutEvent() {
    	genererUnEvenement();
    	System.out.println("Un évenement apparait, si vous vous situez sur les cases 'X' au prochain tour, vous prendez des dégats");
    	afficherEvent();
    	if (joueurDanger())
    		System.out.println(" /!\\ Vous êtes sur une case à risque /!\\ ");
    }
    
    public static void finEvent() {
    	if (joueurDanger()) {
    		System.out.println("L'évemenent vous a frappé, vous perdez une vie");
    		Personnages.modifierVie(-1);
    	}
    }
    
    
}
