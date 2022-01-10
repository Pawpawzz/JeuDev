package main;

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
    		terrainEvenement[ligne][terrainEvenement.length/2] = 23;
    	}
    	for (int colonne = 0; colonne < terrainEvenement.length; colonne++) {
    		terrainEvenement[terrainEvenement.length/2][colonne] = 23;
    	}
    }

    public static void evenementCercle() {
    	 
    }
    
    public static void evenementUneCaseSurTrois() {
    	for (int ligne = 0; ligne < terrainEvenement.length; ligne++) {
    		for (int colonne = 0; colonne < terrainEvenement.length; colonne++) {
    			if (colonne%3 == 0)
    				terrainEvenement[ligne][colonne] = 23;
    		}
    	}
    }
    
    public static void evenementCarréHaché() { //et non pas steak haché
    	for (int ligne = 1; ligne < terrainEvenement.length-1; ligne++) {
    		if (ligne%(terrainEvenement.length/4) != 0)
    			for (int colonne = 1; colonne < terrainEvenement.length-1; colonne++) {
    				terrainEvenement[ligne][colonne] = 23;
    		}
    	}
         
    }
    
    
}
