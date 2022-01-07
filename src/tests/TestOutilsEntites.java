package tests;

import main.Terrain;
import main.outils.OutilsEntites;
import org.junit.Test;

import static main.Constantes.VALEUR_JOUEUR;
import static org.junit.Assert.assertEquals;

public class TestOutilsEntites {
    @Test
    public void TestRecupererDirection() {

        //Terrain.genererTerrain(6);
        //Terrain.recupererTerrain()[3][4] = VALEUR_JOUEUR;

        int[] positionJoueur = {5,3};

        int[] positionEnnemi = {5,5};
        int[] positionEnnemi2 = {3,4};
        int[] positionEnnemi3 = {8,5};

        assertEquals('h', OutilsEntites.recupererDirection(positionEnnemi, positionJoueur));
        assertEquals('d', OutilsEntites.recupererDirection(positionEnnemi2, positionJoueur));
        assertEquals('g', OutilsEntites.recupererDirection(positionEnnemi3, positionJoueur));


    }
}
