package tests;

import main.Terrain;
import main.outils.OutilsTableaux;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTerrain {
    @Test
    public void TestValeurCaseACote() {
        Terrain.genererTerrain(5, false);
        int[][] terrain = Terrain.recupererTerrain();

        terrain[0][1] =  3;
        terrain[1][0] =  10;

        terrain[4][3] =  23;
        terrain[3][4] =  0;

        int[] positionOrigine = {0, 0};
        int[] positionEnBasDroite = {4, 4};

        assertEquals(3, OutilsTableaux.valeurCaseACote(terrain, 'd', positionOrigine));
        assertEquals(10, OutilsTableaux.valeurCaseACote(terrain, 'b', positionOrigine));

        assertEquals(23, OutilsTableaux.valeurCaseACote(terrain, 'g', positionEnBasDroite));
        assertEquals(0, OutilsTableaux.valeurCaseACote(terrain, 'h', positionEnBasDroite));
    }

    @Test
    public void TestPositionCaseACote() {
        Terrain.genererTerrain(5, false);
        int[][] terrain = Terrain.recupererTerrain();


        assertArrayEquals(new int[]{0,1}, OutilsTableaux.positionCaseACote(terrain, 'd', new int[]{0,0}));
        assertArrayEquals(new int[]{-1,-1}, OutilsTableaux.positionCaseACote(terrain, 'g', new int[]{0,0}));
        assertArrayEquals(new int[]{-1,-1}, OutilsTableaux.positionCaseACote(terrain, 'h', new int[]{0,0}));
        assertArrayEquals(new int[]{0,1}, OutilsTableaux.positionCaseACote(terrain, 'd', new int[]{0,0}));
    }
}
