package main;

import main.affichage.Menu;

import java.util.function.Function;

import static main.Constantes.VALEUR_MIN_ENNEMI;

public class ControlleurCombat {

    public static void lancerCombat() {
        Terrain.genererTerrain(6);

        int archer = VALEUR_MIN_ENNEMI;
        int taureau = VALEUR_MIN_ENNEMI + 1;

        int[] tabEnnemis = {archer,taureau};
        Terrain.placerEnnemis(tabEnnemis);

        int tour = 1;
        int delaiEvenement = 3;

        while(Personnages.recupererVie() > 0) {
            if((tour +1) % delaiEvenement == 0) {
                System.out.println("Il y aura un évenement de type [type] au prochain tour");
                Evenement.genererUnEvenement();
            }
            System.out.println("Tour n°" + tour);
            Menu.afficherActionsJoueur();
            System.out.println(">Mouvement ennemis<");

            Ennemis.effectuerTourEnnemis();
            //System.out.println("[TEST] Tu perds une vie ");

            if(tour % delaiEvenement == 0) {
                System.out.println("Attention un vent violent frappe du côté est");

            }

            tour+=1;
        }

        System.out.println("Tu as perdu");

    }




}
