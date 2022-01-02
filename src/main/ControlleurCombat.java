package main;

import main.affichage.Menu;

import java.util.function.Function;

public class ControlleurCombat {


    public static void lancerCombat() {
        Terrain.genererTerrain(6);

        while(Personnages.recupererVie() > 0) {
            Menu.afficherActionsJoueur();
            System.out.println(">Programmer tour des ennemis<");

            Personnages.modifierVie(-1);
            System.out.println("[TEST] Tu perds une vie ");
        }

        System.out.println("Tu as perdu");



    }


}
