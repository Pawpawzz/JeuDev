package main;

import main.affichage.Menu;

import java.util.function.Function;

public class ControlleurCombat {

    public static void lancerCombat() {
        Terrain.genererTerrain(6);
        int[] tabEnnemis = {10,11};
        Terrain.placerEnnemis(tabEnnemis);

        while(Personnages.recupererVie() > 0) {
            Menu.afficherActionsJoueur();
            System.out.println(">Mouvement ennemis<");

            Ennemis.effectuerTourEnnemis();
            System.out.println("[TEST] Tu perds une vie ");
        }

        System.out.println("Tu as perdu");

    }




}
