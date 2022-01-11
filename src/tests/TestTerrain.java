package tests;

import main.Terrain;
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

        assertEquals(3, Terrain.valeurCaseACote('d', positionOrigine));
        assertEquals(10, Terrain.valeurCaseACote('b', positionOrigine));

        assertEquals(23, Terrain.valeurCaseACote('g', positionEnBasDroite));
        assertEquals(0, Terrain.valeurCaseACote('h', positionEnBasDroite));
    }

    @Test
    public void TestPositionCaseACote() {
        Terrain.genererTerrain(5, false);
        //int[][] terrain = Terrain.recupererTerrain();

        assertArrayEquals(new int[]{0,1}, Terrain.positionCaseACote('d', new int[]{0,0}));
        assertArrayEquals(new int[]{-1,-1}, Terrain.positionCaseACote('g', new int[]{0,0}));
        assertArrayEquals(new int[]{-1,-1}, Terrain.positionCaseACote('h', new int[]{0,0}));
        assertArrayEquals(new int[]{0,1}, Terrain.positionCaseACote('d', new int[]{0,0}));
    }
}
