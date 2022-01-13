package main.affichage;

import main.Personnages;

public class AffichagePersonnages {
    public static void afficherNombreVie() {
        int nbVie = Personnages.recupererVie();
        int maxVie = Personnages.recuperMaxVie();

        for(int i = 1; i <= maxVie; i++) {
            if(i > nbVie)
                System.out.print("♡");
            else
                System.out.print("❤");
        }

        System.out.println();
    }

    
    public static void afficherAction(boolean attaque) {
    	if (attaque)
    		System.out.println("Attaque");
    	else
    		System.out.println("Se déplace");
    }
    
}
