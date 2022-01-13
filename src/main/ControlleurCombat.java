package main;

import main.affichage.Menu;

import static main.Constantes.VALEUR_ARCHER;
import static main.Constantes.VALEUR_TAUREAU;
import static main.Constantes.TOUR_EVENEMENT;
import static main.outils.OutilsEntites.recupererToutesLesPositionEnnemis;


public class ControlleurCombat {

    public static void lancerCombat() {
        Terrain.genererTerrain(6, false);



        int[] tabEnnemis = {VALEUR_TAUREAU,VALEUR_ARCHER};
        Terrain.placerEnnemis(tabEnnemis);

        int tour = 1;
        boolean evenementFrappe = false;

        while(Joueur.estEnVie() && recupererToutesLesPositionEnnemis().size() > 0) {

            System.out.println("Tour n°" + tour);
<<<<<<< Updated upstream
            if (evenementFrappe) {
            	Evenement.finEvent();
                evenementFrappe = false;
            }
            if (tour%TOUR_EVENEMENT == 0) {
            	Evenement.debutEvent();
            	evenementFrappe = true;
=======

            if (evenementFrappe)
                Evenement.finEvent();
            if (tour % TOUR_EVENEMENT == 0) {
                Evenement.debutEvent();
                evenementFrappe = true;
>>>>>>> Stashed changes
            }

            Menu.afficherActionsJoueur();
            Ennemi.effectuerTourEnnemis();

            tour += 1;

        }

        if(Joueur.estEnVie())
            System.out.println("Vous avez gagné");
        else
            System.out.println("Vous avez perdu");

    }
}
