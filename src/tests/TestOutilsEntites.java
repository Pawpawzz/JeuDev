package tests;

import main.Terrain;
import main.outils.OutilsEntites;
import org.junit.Test;

import static main.Constantes.VALEUR_JOUEUR;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestOutilsEntites {
    @Test
    public void TestDistanceEntreDeux() {
        assertEquals(2, OutilsEntites.distanceEntreDeux(new int[] {0, 0}, new int[] {1, 1}));
        assertEquals(3, OutilsEntites.distanceEntreDeux(new int[] {0, 0}, new int[] {1, 2}));
    }
}
