package main.affichage;

public class AffichagePersonnage {
    public static void afficherNombreVie(int nbVie, int maxVie) {
        for(int i = 1; i <= maxVie; i++) {
            if(i > nbVie)
                System.out.print("♡");
            else
                System.out.print("♥");
        }

        System.out.println();
    }
}
