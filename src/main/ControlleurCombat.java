package main;

import main.affichage.Menu;

import java.util.function.Function;

import static main.Constantes.VALEUR_MIN_ENNEMI;

public class ControlleurCombat {

    public static void lancerCombat() {
        Terrain.genererTerrain(6, false);

        int archer = VALEUR_MIN_ENNEMI;
        int taureau = VALEUR_MIN_ENNEMI + 1;

        int[] tabEnnemis = {archer,taureau};
        Terrain.placerEnnemis(tabEnnemis);

        int tour = 1;
        boolean evenementFrappe = false;

        while(Personnages.recupererVie() > 0) {
            System.out.println("Tour n°" + tour);
            if (evenementFrappe)
            	Evenement.finEvent();
            if (tour%5 == 0) {
            	Evenement.debutEvent();
            	evenementFrappe = true;
            }
            Menu.afficherActionsJoueur();
            /*System.out.println(">Mouvement ennemis<");
             */
            Ennemis.effectuerTourEnnemis();
            //System.out.println("[TEST] Tu perds une vie ");*/


            tour+=1;
        }

        System.out.println("Tu as perdu");

    }
    

    
    




}
